import java.util.*;
public class shortURL{
    public static void main(String[] arg){
        String oUrl = "https://courses.telusko.com/learn/Live-Java-Course";
        shortLinkService sls = new shortLinkService();
        sls.fillUrls(10);
        String sUrl = sls.handleOUrl(oUrl);
        System.out.println(sUrl);
        System.out.println(sls.hashedUrls);
    }
}
class shortLinkService{
    static int i=0;
    Random random = new Random();
    HashMap<String , String> hashedUrls = new HashMap<>();
    public String handleOUrl(String oUrl){
        String sUrl;
        if(!ifContainsOUrl(oUrl)){
            sUrl = generateUrl(oUrl);
            addGeneratedUrl(oUrl, sUrl);
        }
        else{
            sUrl = hashedUrls.get(oUrl);
        }
        return sUrl;
    }
    private void addGeneratedUrl(String oUrl, String sUrl){
        hashedUrls.put(oUrl,sUrl);
    }
    private boolean ifContainsOUrl(String oUrl){
        return hashedUrls.containsKey(oUrl);
    }
    private boolean ifContainsSUrl(String sUrl){
        return hashedUrls.containsValue(sUrl);
    }

    public void fillUrls(int n){
        for(int i=0;i<n;i++){
            handleOUrl(generateUrl("abcdesf.com"));
        }
    }

    private String generateUrl(String oUrl){
        StringBuilder sb = new StringBuilder();
        int randomIndex;
        String sUrl;
        StringBuilder oUrlSb = new StringBuilder();
        for(int i=0;i<oUrl.length();i++){
            if(Character.isLetter(oUrl.charAt(i))){
                oUrlSb.append(oUrl.charAt(i));
            }
        }
        oUrl = oUrlSb.toString();
        do{
            for(int i=0;i<6;i++){
                randomIndex = random.nextInt(oUrl.length());
                sb.append(oUrl.charAt(randomIndex));
            }
        sUrl = "shortURL.co/"+sb.toString();
        System.out.println("Generated....:"+i+" "+ sUrl);
        i++;
        }while(ifContainsSUrl(sUrl));

        return sUrl;
    }
}
