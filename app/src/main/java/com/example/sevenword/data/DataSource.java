package com.example.sevenword.data;

import com.example.sevenword.R;
import com.example.sevenword.data.models.Topic;
import com.example.sevenword.data.models.Word;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TienBM on 12/16/2017.
 */

public class DataSource {

    private static DataSource sDataSource = new DataSource();

    public static DataSource getInstance() {
        return sDataSource;
    }

    private List<Topic> topics;

    private DataSource() {
        topics = new ArrayList<>();
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public Topic getTopicById(int idTopic) {
        for (Topic topic : topics) {
            if (topic.getId() == idTopic) {
                return topic;
            }
        }
        return new Topic();
    }

    public void initData() {
        Topic topicComputer = new Topic(0, "Computer", "Máy tính", R.drawable.computer);
        List<Word> wordsComputer = new ArrayList<>();
        wordsComputer.add(new Word("start up", "mở máy"));
        wordsComputer.add(new Word("shut down the computer", "tắt máy"));
        wordsComputer.add(new Word("desktop", "màn hình nền"));
        wordsComputer.add(new Word("icons", "biểu tượng"));
        wordsComputer.add(new Word("access the internet", "truy cập mạng internet"));
        wordsComputer.add(new Word("home page", "Trang chủ"));
        wordsComputer.add(new Word("recycle bin", "Thùng rác máy tính"));
        wordsComputer.add(new Word("back up the files", "Lưu giữ tập tin dự phòng"));
        wordsComputer.add(new Word("install a program", "Cài đặt một chương trình"));
        topicComputer.setWords(wordsComputer);
        topics.add(topicComputer);

        Topic topicEat = new Topic(1, "Eating habits", "Chế độ ăn", R.drawable.eat);
        List<Word> wordEat = new ArrayList<>();
        wordEat.add(new Word("junk food", "Các loại đồ ăn vặt"));
        wordEat.add(new Word("fast food", "Đồ ăn nhanh"));
        wordEat.add(new Word("overweight ", "Béo,cân nặng"));
        wordEat.add(new Word("processed foods", "Thức ăn qua chế biến sẵn"));
        wordEat.add(new Word("food additives", "Chất phụ gia"));
        wordEat.add(new Word("go on a diet", "Thực hiện chế độ ăn kiêng"));
        wordEat.add(new Word("fresh produce", "Những sản phẩm tươi sạch"));
        topicEat.setWords(wordEat);
        topics.add(topicEat);


        Topic topicSpeed = new Topic(2, "Speed", "Tốc độ", R.drawable.speed);
        List<Word> wordsTopicSpeed = new ArrayList<>();
        wordsTopicSpeed.add(new Word("fast ", "Xe chạy nhanh"));
        wordsTopicSpeed.add(new Word("a fast runner", "Người chạy nhanh"));
        wordsTopicSpeed.add(new Word("a quick lunch", "Bữa ăn nhanh"));
        wordsTopicSpeed.add(new Word("a quick shower", "Tắm nhanh"));
        wordsTopicSpeed.add(new Word("a quick decision", "Một quyết định nhanh chóng"));
        wordsTopicSpeed.add(new Word("a rapid increase", "Sự tăng"));
        wordsTopicSpeed.add(new Word("a rapid decline", "Sự giảm"));
        wordsTopicSpeed.add(new Word("rapid progress", "Tiến triển nhanh"));
        wordsTopicSpeed.add(new Word("rapid growth", "Phát triển nhanh"));
        topicSpeed.setWords(wordsTopicSpeed);
        topics.add(topicSpeed);

        Topic topicMoney = new Topic(3, "Money", "Tiền bạc", R.drawable.money);
        List<Word> wordsTopicMoney = new ArrayList<>();
        wordsTopicMoney.add(new Word("ask mom/dad for money", "Xin tiền từ bố mẹ"));
        wordsTopicMoney.add(new Word("make money", "Kiếm tiền"));
        wordsTopicMoney.add(new Word("inherit money", "Hưởng tiền bạc"));
        wordsTopicMoney.add(new Word("wealthy", "Giàu có"));
        wordsTopicMoney.add(new Word("make a deposit", "Gửi tiền vào ngân hàng"));
        wordsTopicMoney.add(new Word("make a withdrawal", "Rút tiền từ ngân hàng"));
        wordsTopicMoney.add(new Word("cash machines", "Máy rút tiền tự động"));
        topicMoney.setWords(wordsTopicMoney);
        topics.add(topicMoney);

        Topic topicBusiness = new Topic(4, "Business", "Kinh doanh", R.drawable.bussines);
        List<Word> wordsTopicBusiness = new ArrayList<>();
        wordsTopicBusiness.add(new Word("go into business for ourselves", "Tự kinh doanh"));
        wordsTopicBusiness.add(new Word("open/set up/establish a company", "Thành lập công ty"));
        wordsTopicBusiness.add(new Word("do market research", "Nghiên cứu thị trường"));
        wordsTopicBusiness.add(new Word("start to break even", "Bắt đầu hòa vốn"));
        wordsTopicBusiness.add(new Word("there’s tough competition", "Có cạnh tranh"));
        wordsTopicBusiness.add(new Word("gain market share", "Giành thị phần"));
        wordsTopicBusiness.add(new Word("run the risk of going bankrupt", "Nguy cơ phá sản"));
        topicBusiness.setWords(wordsTopicBusiness);
        topics.add(topicBusiness);

    }
}
