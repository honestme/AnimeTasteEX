package com.honestme.animetasteex;

import android.net.Uri;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangconglin on 2016/1/11.
 */
public class ATEApiUtil {
    public static final int ATE_MAIN = 0;
    public static final int ATE_INTERVIEW = 1;
    public static final int ATE_WEEKLY_INSPIRATIONS = 2;
    public static final int ATE_AMZ = 3;
    public static final int ATE_SUGER = 4;
    public static final int ATE_ATTENTION = 5;

    public static final String ATE_MAIN_URL = "http://animetaste.net";
    public static final String ATE_INTERVIEW_URL = "animetaste.net/category/interview";
    public static final String ATE_WEEKLY_INSPIRATIONS_URL = "animetaste.net/category/weekly-inspirations";
    public static final String ATE_AMZ_URL = "http://aimozhen.com";
    public static final String ATE_SUGER_URL = "http://bingtanghuluer.com/";
    public static final String ATE_ATTENTION_URL = "";


    public static final int ATE_AMZ_SHARE = 10;
    public static final int ATE_AMZ_ORIGIN = 11;
    public static final int ATE_AMZ_CREATOR = 12;
    public static final int ATE_AMZ_COLLECTION = 13;


    public static final int ATE_AMZ_CATEGORY_SHORT_FILM = 14;
    public static final int ATE_AMZ_CATEGORY_MV = 15;
    public static final int ATE_AMZ_CATEGORY_ADVERTISE = 16;
    public static final int ATE_AMZ_CATEGORY_ORIGINALITY = 17;
    public static final int ATE_AMZ_CATEGORY_TV_PACK = 18;
    public static final int ATE_AMZ_CATEGORY_MIX = 19;
    public static final int ATE_AMZ_CATEGORY_SIDELIGHTS = 20;
    public static final int ATE_AMZ_CATEGORY_DOCUMENTARY = 21;
    public static final int ATE_AMZ_CATEGORY_NOT_RECOGNISED = 22;


    public static final String ATE_AMZ_SHARE_URL = "http://aimozhen.com/share";
    public static final String ATE_AMZ_ORIGIN_URL = "http://aimozhen.com/origin";
    public static final String ATE_AMZ_CREATOR_URL = "http://aimozhen.com/creator";
    public static final String ATE_AMZ_COLLECTION_URL = "http://aimozhen.com/collection";

    public static final String ATE_AMZ_CATEGORY_SHORT_FILM_URL = "http://aimozhen.com/category/2";
    public static final String ATE_AMZ_CATEGORY_MV_URL = "http://aimozhen.com/category/3";
    public static final String ATE_AMZ_CATEGORY_ADVERTISE_URL = "http://aimozhen.com/category/4";
    public static final String ATE_AMZ_CATEGORY_ORIGINALITY_URL = "http://aimozhen.com/category/5";
    public static final String ATE_AMZ_CATEGORY_TV_PACK_URL = "http://aimozhen.com/category/6";
    public static final String ATE_AMZ_CATEGORY_MIX_URL = "http://aimozhen.com/category/8";
    public static final String ATE_AMZ_CATEGORY_SIDELIGHTS_URL = "http://aimozhen.com/category/9";
    public static final String ATE_AMZ_CATEGORY_DOCUMENTARY_URL = "http://aimozhen.com/category/10";
    public static final String ATE_AMZ_CATEGORY_NOT_RECOGNISED_URL = "http://aimozhen.com/category/1";

    public static String getFormatUri(int type,int page){
        StringBuffer stringBuffer = new StringBuffer();

        switch (type){
            case ATE_MAIN:
                stringBuffer.append(ATE_MAIN_URL);
                break;
            case ATE_INTERVIEW:
                stringBuffer.append(ATE_INTERVIEW_URL);
                break;
            case ATE_WEEKLY_INSPIRATIONS:
                stringBuffer.append(ATE_WEEKLY_INSPIRATIONS_URL);
                break;
            case ATE_AMZ:
                stringBuffer.append(ATE_AMZ_URL);
                break;
            case ATE_SUGER:
                stringBuffer.append(ATE_SUGER_URL);
                break;
            case ATE_ATTENTION:
                stringBuffer.append(ATE_ATTENTION_URL);
                break;
        }

        stringBuffer.append("/page/" + page);

        return stringBuffer.toString();
    }

    public static String getFormatUrlAMZ(int type,int page){
        StringBuffer stringBuffer = new StringBuffer();

        switch (type){
            case ATE_AMZ_SHARE:
                stringBuffer.append(ATE_AMZ_SHARE_URL);
                break;
            case ATE_AMZ_ORIGIN:
                stringBuffer.append(ATE_AMZ_ORIGIN_URL);
                break;
            case ATE_AMZ_CREATOR:
                stringBuffer.append(ATE_AMZ_CREATOR_URL);
                break;
            case ATE_AMZ_COLLECTION:
                stringBuffer.append(ATE_AMZ_COLLECTION_URL);
                break;
            case ATE_AMZ_CATEGORY_SHORT_FILM:
                stringBuffer.append(ATE_AMZ_CATEGORY_SHORT_FILM_URL);
                break;
            case ATE_AMZ_CATEGORY_ADVERTISE:
                stringBuffer.append(ATE_AMZ_CATEGORY_ADVERTISE_URL);
                break;
            case ATE_AMZ_CATEGORY_DOCUMENTARY:
                stringBuffer.append(ATE_AMZ_CATEGORY_DOCUMENTARY_URL);
                break;
            case ATE_AMZ_CATEGORY_MIX:
                stringBuffer.append(ATE_AMZ_CATEGORY_MIX_URL);
                break;
            case ATE_AMZ_CATEGORY_MV:
                stringBuffer.append(ATE_AMZ_CATEGORY_MV_URL);
                break;
            case ATE_AMZ_CATEGORY_ORIGINALITY:
                stringBuffer.append(ATE_AMZ_CATEGORY_ORIGINALITY_URL);
                break;
            case ATE_AMZ_CATEGORY_TV_PACK:
                stringBuffer.append(ATE_AMZ_CATEGORY_TV_PACK_URL);
                break;
            case ATE_AMZ_CATEGORY_SIDELIGHTS:
                stringBuffer.append(ATE_AMZ_CATEGORY_SIDELIGHTS_URL);
                break;
            case ATE_AMZ_CATEGORY_NOT_RECOGNISED:
                stringBuffer.append(ATE_AMZ_CATEGORY_NOT_RECOGNISED_URL);
                break;
            default:break;
        }

        stringBuffer.append("/page:" + page);
        return stringBuffer.toString();
    }

    public static String getHtmlFromUrl(String urlStr) throws Exception{
        StringBuffer stringBuffer = new StringBuffer();

        try {
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            if(connection.getResponseCode() == 200){
                InputStream inputStream = connection.getInputStream();
                int length = 1024;
                byte[] buffer = new byte[1024];
                while(inputStream.read(buffer) != -1){
                    stringBuffer.append(new String(buffer,0,length,"UTF-8"));
                }
                inputStream.close();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return stringBuffer.toString();
    }


    public static List<ATEListItem> getDataFromUriMain(int type,int page){
        List<ATEListItem> itemList = new ArrayList<ATEListItem>();


        String formatUrl = getFormatUri(type, page);

        Uri uri = Uri.parse(formatUrl);
        try {
            String htmlStr = getHtmlFromUrl(formatUrl);
            Document document = Jsoup.parse(htmlStr);
            Elements elements = document.select("section.post");


            for(int i = 0; i < elements.size();++i){
                ATEListItem item = new ATEListItem();
                Element elementItem = elements.get(i);
                Element element = elementItem.select("post").get(0);
                Element elementViewTimes = element.select(".post-viewed").get(0);
                String viewTimes = elementViewTimes.text();
                item.setmViewTimes(viewTimes);

                Element elementTitle = element.select(".post-title").get(0);
                String title = elementTitle.text();
                String contentLink = elementTitle.attr("href");
                item.setmTitle(title);
                item.setmContentLink(contentLink);

                Element elementAuthor = element.select(".post-author").get(0);
                String author = elementAuthor.text();
                item.setmAuthor(author);

                Element elementMain = element.select(".post-main").get(0);
                String imageUrl = elementMain.select(".post-thumbnail").get(0).attr("src");
                item.setmImageUrl(imageUrl);




                itemList.add(item);

            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

        return itemList;
    }





    public static List<AMZListItem> getDataFromUriAMZ(int type,int page){
        List<AMZListItem> itemList = new ArrayList<>();

        String formatUrl = getFormatUrlAMZ(type, page);

        try {
            String htmlStr = getHtmlFromUrl(formatUrl);
            Document document = Jsoup.parse(htmlStr);

            Elements elements = document.select(".video-card");

            for(int i = 0;i<elements.size();++i){
                AMZListItem item = new AMZListItem();


                Element elementThumb = elements.select(".thumb").get(0);
                Element elementInfo = elements.select(".info").get(0);

                Element elementImageUrl = elementThumb.getElementsByClass("custom-background").get(0);
                String tempImageUrl = elementImageUrl.attr("style");
                String[] tempStrArray = tempImageUrl.split("[']");
                String imageUrl = tempStrArray[1];
                item.setmImageUrl(imageUrl);

                Element elementLink = elementThumb.getElementsByAttribute("target").get(0);
                String partLink = elementLink.attr("href");
                String link = ATE_AMZ_URL + partLink;
                item.setmLink(link);

                Element elementContent = elementThumb.getElementsByClass("content").get(0);
                String contentTop = elementContent.text();
                item.setmTopContent(contentTop);

                Element elementDate = elementThumb.getElementsByClass("date").get(0);
                String date = elementDate.text();
                item.setmDate(date);

                Element elementBottomContent = elementInfo.getElementsByAttribute("target").get(0);
                String contentBottom = elementBottomContent.text();
                item.setmBottomContent(contentBottom);

                Element elementViewTimes = elementInfo.getElementsByClass("count").get(0);
                String viewTimes = elementViewTimes.text();
                item.setmViewTimes(viewTimes);

                Element elementUser = elementInfo.getElementsByClass("user").get(0);
                Element elementVimeo = elementUser.getElementsByTag("a").get(0);
                Element elementBottomImageUrl = elementVimeo.getElementsByTag("img").get(0);
                String  bottomImageUrl = elementBottomImageUrl.attr("src");
                item.setmBottomImageUrl(imageUrl);

                itemList.add(item);
            }



        }catch (Exception ex){
            ex.printStackTrace();
        }

        return itemList;
    }


    public static List<ATEListItem> getDataFromUriMainOrigin(int type,int page){
        List<ATEListItem> itemList = new ArrayList<ATEListItem>();


        String formatUrl = getFormatUri(type, page);


        try {
            String htmlStr = getHtmlFromUrl(formatUrl);
            Document document = Jsoup.parse(htmlStr);
            Elements elements = document.select("div.post");
            Elements elementsAMZ= document.select(".post.amz-post");

            for(int i = 0; i < elements.size();++i){
                ATEListItem item = new ATEListItem();
                Element element = elements.get(i);
                Element elementViewTimes = element.select(".post-viewed").get(0);
                String viewTimes = elementViewTimes.text();
                item.setmViewTimes(viewTimes);

                Element elementTitle = element.select(".post-title").get(0);
                String title = elementTitle.text();
                String contentLink = elementTitle.attr("href");
                item.setmTitle(title);
                item.setmContentLink(contentLink);

                Element elementAuthor = element.select(".post-author").get(0);
                String author = elementAuthor.text();
                item.setmAuthor(author);

                Element elementMain = element.select(".post-main").get(0);
                String imageUrl = elementMain.select(".post-thumbnail").get(0).attr("src");
                item.setmImageUrl(imageUrl);

                Element elementAMZ = elementsAMZ.get(i);
                Element elementContent = elementAMZ.select(".content").get(0);
                Element elementAnimeTitle = elementContent.select("title").get(0);
                String animeTitle = elementAnimeTitle.text();
                String animeLink = elementAnimeTitle.attr("href");
                Element elementAnimeDescription = elementContent.select("description").get(0);
                String animeContent = elementAnimeDescription.text();
                item.setmAnimeLink(animeLink);
                item.setmAnimeContent(animeContent);
                item.setmAnimeTitle(animeTitle);

                itemList.add(item);

            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

        return itemList;
    }

    public static InterviewItemDetail interviewDetail(String urlStr){

        InterviewItemDetail item = new InterviewItemDetail();

        try {

            String htmlStr = getHtmlFromUrl(urlStr);
            Document document = Jsoup.parse(htmlStr);

            Element element = document.select("div.post").get(0);

            Element elementTitle = element.select(".post-title").get(0);
            String title = elementTitle.text();
            String animeLink = elementTitle.attr("href");
            item.setTitle(title);
            item.setAnimeLink(animeLink);

            Element elementAuthor = element.select(".post-author").get(0);
            String author = elementAuthor.text();
            String authorLink = elementAuthor.attr("href");

            Element elementContent = element.select(".in-post-content").get(0);
            Elements elementsInterview = elementContent.select("a");

            for (int i = 0; i < elementsInterview.size(); ++i) {

            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    return item;

}}
