package calss1.ex;

public class MovieReviewmain2 {

    public static void main(String[] args) {
        MovieReview inception = new MovieReview();
        inception.title = "인셉션";
        inception.review = "인생은 무한루프";

        MovieReview aboutTime = new MovieReview();
        aboutTime.title = "어바웃 타임";
        aboutTime.review = "인생은 시간 영화";

        MovieReview[] mr  =  {aboutTime,inception};

        for (MovieReview mr1 : mr) {
            System.out.println("영화 제목 :" + mr1.title + ", 리뷰 :" + mr1.review);
        }
    }
}
