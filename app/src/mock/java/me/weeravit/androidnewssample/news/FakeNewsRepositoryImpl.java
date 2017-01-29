package me.weeravit.androidnewssample.news;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import me.weeravit.androidnewssample.manager.JsonManager;

/**
 * Created by weeravit on 1/29/2017 AD.
 */

public class FakeNewsRepositoryImpl implements NewsRepository {

    private String data = "[\n" +
            "  {\n" +
            "    \"title\": \"Android Development Best Practices\",\n" +
            "    \"image_url\": \"https://cdn-images-1.medium.com/max/1600/1*vlu_PGh1JnMJhfIzHkPyeA.png\",\n" +
            "    \"link\": \"https://blog.mindorks.com/android-development-best-practices-83c94b027fd3\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"title\": \"The best way to learn new technologies is by doing. Here’s some inspiration.\",\n" +
            "    \"image_url\": \"https://cdn-images-1.medium.com/max/2000/1*QZakZzVvN5WMnVI1cfrq0g.jpeg\",\n" +
            "    \"link\": \"https://hackernoon.com/the-best-way-to-learn-new-technologies-is-by-doing-heres-some-inspiration-6ca144216790\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"title\": \"Learning AI if You Suck at Math\",\n" +
            "    \"image_url\": \"https://cdn-images-1.medium.com/max/2000/1*GBvjI417x6XdhRV6S87Osg.jpeg\",\n" +
            "    \"link\": \"https://hackernoon.com/learning-ai-if-you-suck-at-math-8bdfb4b79037\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"title\": \"Why developers are scared to refactor code ?\",\n" +
            "    \"image_url\": \"https://cdn-images-1.medium.com/max/1760/1*Z4NTvY3umivs1tKrtUVB3Q.png\",\n" +
            "    \"link\": \"https://medium.com/mobility/why-developers-scared-to-refactor-code-47efd1b854e7\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"title\": \"Top 7 algorithms and data structures every programmer should know about\",\n" +
            "    \"image_url\": \"https://cdn-images-1.medium.com/max/1760/0*uoBLO4-ZdTaREnRe.png\",\n" +
            "    \"link\": \"https://medium.com/@hackerearth/top-7-algorithms-and-data-structures-every-programmer-should-know-about-74a61e011940\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"title\": \"SOLID Principles : The Definitive Guide\",\n" +
            "    \"image_url\": \"https://cdn-images-1.medium.com/max/2000/1*LcsyJRuNmvg31Va1M2OZgA.png\",\n" +
            "    \"link\": \"https://android.jlelse.eu/solid-principles-the-definitive-guide-75e30a284dea\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"title\": \"Big O Notation สำคัญไฉน มาทบทวนกันหน่อย (Part 1) — ความหมาย และประเภทของ Big O\",\n" +
            "    \"image_url\": \"https://cdn-images-1.medium.com/max/1600/1*P8BqNqVdhieXPEyS32UeeQ.jpeg\",\n" +
            "    \"link\": \"https://developers.ascendcorp.com/what-why-and-type-big-o-notation-90a1a1d43596\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"title\": \"Android Code Style And Guidelines\",\n" +
            "    \"image_url\": \"https://cdn-images-1.medium.com/max/1600/1*axK3Yu1Yrkc8pblFiHn6-g.png\",\n" +
            "    \"link\": \"https://blog.mindorks.com/android-code-style-and-guidelines-d5f80453d5c7\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"title\": \"Few simple rules for good coding(my 15 years experience)\",\n" +
            "    \"image_url\": \"\",\n" +
            "    \"link\": \"https://android.jlelse.eu/few-simple-rules-to-write-good-code-my-15-years-experience-78a133557ec5\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"title\": \"Clean Android Code\",\n" +
            "    \"image_url\": \"\",\n" +
            "    \"link\": \"https://android.jlelse.eu/keep-your-droid-clean-e9c093140eb6\"\n" +
            "  }\n" +
            "]\n";

    @Override
    public void getNews(int page, final Callback callback) {
        Gson gson = JsonManager.getInstance().getGson();
        List<News> newsList = gson.fromJson(data, new TypeToken<List<News>>() {
        }.getType());
        callback.onSuccess(newsList);
    }

}
