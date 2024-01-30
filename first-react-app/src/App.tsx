import React, { useState } from "react";
import axios from "axios";
import zod from 'zod';
import Redirect from "./components/Redirect";

const App: React.FC = () => {
    const [originalUrl, setOriginalUrl] = useState("");
    const [shortUrl, setShortUrl] = useState("");
    const [error, setError] = useState("");

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        try {
            const {success} = zod.string().url().safeParse(originalUrl);
            if(!success){
                throw new Error('check your input');
            }
            await axios.get(originalUrl);
            const response = await axios.get(
                `http://localhost:8080/shorter?url=${originalUrl}`,
                    {url: originalUrl}
            );
            const data = response.data;
            setError('');
            setShortUrl(data.shortUrl);
        } catch (error: any) {
            console.error(error);
            setError(error.message);
            setShortUrl("");
        }
    };

    return (
        <div className="App">
            <h1>URL Shortener</h1>
                <form onSubmit={handleSubmit}>
                    <div>
                        <input
                        type="text"
                        value={originalUrl}
                        onChange={(e) => setOriginalUrl(e.target.value)}
                        placeholder="Enter URL"
                        />
                    </div>
                    <div>
                        <button type="submit">Shorten</button>
                    </div>
                    <div>
                        {error}
                    </div>
                </form>
            {shortUrl && (
                <Redirect shortUrl={shortUrl}/>
            )}
        </div>
    );
};

export default App;
