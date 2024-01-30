interface PropTypes{
    shortUrl: string
}

export default function Redirect(props: PropTypes){
    
    return (
        <>
            <div>
              <p>Shortened URL:</p>
              <a href={'http://localhost:8080/'+props.shortUrl.split('/')[1]} target="_blank" rel="noopener noreferrer">
                {props.shortUrl}
              </a>
            </div>
        </>
    )
}
