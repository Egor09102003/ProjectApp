package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SMOL extends AppCompatActivity {

    int answer = 0;
    int i = 69;
    String res = null;
    String[] questions = new String[] {"1. У Вас хороший аппетит.", "2. По утрам Вы обычно чувствуете" +
            ", что выспались и отдохнули." , "3. В Вашей повседневной жизни масса интересного."
            , "4. Вы работаете с большим напряжением."
            , "5. Временами Вам приходят в голову такие нехорошие мысли, что о них лучше не рассказывать."
            , "6. У Вас очень редко бывает запор." ,"7. Иногда Вам очень хотелось навсегда уйти из дома."
            , "8. Временами у Вас бывают приступы неудержимого смеха или плача."
            , "9. Временами Вас беспокоят тошнота и позывы на рвоту. "
            , "10. У Вас такое впечатление, что Вас никто не понимает."
            , "11. Иногда Вам хочется выругаться.", "12. Каждую неделю Вам снятся кошмары."
            , "13. Вам труднее сосредоточиться, чем большинству других людей."
            , "14. С Вами происходили (или происходят) странные вещи."
            , "15. Вы достигли бы в жизни гораздо большего, если бы люди не были настроены против Вас."
            , "16. В детстве Вы одно время совершали мелкие кражи."
            , "17. Бывало, что по несколько дней, недель или месяцев Вы ничем не могли заняться, потому что трудно было заставить себя включиться в работу."
            , "18. У Вас прерывистый и беспокойный сон.", "19. Когда Вы находитесь среди людей, Вам слышатся странные вещи. "
            , "20. Большинство знающих Вас людей не считают Вас неприятным человеком."
            , "21. Вам часто приходилось подчиняться кому-нибудь, кто знал меньше Вашего."
            , "22. Большинство людей довольно своей жизнью более, чем Вы. "
            , "23. Очень многие преувеличивают свои несчастья, чтобы добиться сочувствия и помощи."
            , "24. Иногда Вы сердитесь.", "25. Вам определенно не хватает уверенности в себе."
            , "26. Часто у Вас бывают подергивания в мышцах."
            , "27. У Вас очень часто бывает чувство, как будто Вы сделали что-то неправильное или нехорошее."
            , "28. Обычно Вы удовлетворены своей судьбой."
            , "29. Некоторые так любят командовать, что Вам хочется все сделать наперекор, хотя Вы знаете, что они правы."
            , "30. Вы считаете, что против Вас что-то замышляют. "
            , "31. Большинство людей способно добиваться выгоды не совсем честным способом."
            , "32. Вас часто беспокоит желудок."
            , "33. Часто Вы не можете понять, почему накануне Вы были в плохом настроении и раздражены."
            , "34. Временами Ваши мысли текли так быстро, что Вы не успевали их высказывать."
            , "35. Вы считаете, что Ваша семейная жизнь не хуже, чем у большинства Ваших знакомых."
            , "36. Временами Вы уверены в собственной бесполезности."
            , "37. В последние годы Ваше самочувствие в основном было хорошим."
            , "38. У Вас бывали периоды, во время которых Вы что-то делали и потом не могли вспомнить, что именно."
            , "39. Вы считаете, что Вас часто незаслуженно наказывали."
            , "40. Вы никогда не чувствовали себя лучше, чем теперь."
            , "41. Вам безразлично, что думают о Вас другие."
            , "42. С памятью у Вас все благополучно."
            , "43. Вам трудно поддерживать разговор с человеком, с которым Вы только что познакомились."
            , "44. Большую часть времени Вы чувствуете общую слабость.", "45. У Вас редко болит голова."
            , "46. Иногда Вам бывало трудно сохранять равновесие во время ходьбы."
            , "47. Не все Ваши знакомые Вам нравятся.", "48. Есть люди, которые пытаются украсть Ваши идеи и мысли."
            , "49. Вы считаете, что Вы слишком застенчивы."
            , "50. Вы считаете, что совершали поступки, которые нельзя простить."
            , "51. Вы почти всегда о чем-нибудь тревожитесь.", "52. Ваши родители часто не одобряли Ваших знакомств."
            , "53. Иногда Вы немного сплетничаете."
            , "54. Временами Вы чувствуете, что Вам необыкновенно легко принимать решения."
            , "55. У Вас бывает сильное сердцебиение, и Вы часто задыхаетесь."
            , "56. Вы вспыльчивы, но отходчивы."
            , "57. У Вас бывают периоды такого беспокойства, что трудно усидеть на месте."
            , "58. Ваши родители и другие члены семьи часто придираются к Вам."
            , "59. Ваша судьба никого особенно не интересует."
            , "60. Вы не осуждаете человека, который не прочь воспользоваться в своих интересах ошибками другого."
            , "61. Иногда Вы полны энергии.",  "62. За последнее время у Вас ухудшилось зрение."
            , "63. Часто у Вас звенит или шумит в ушах."
            , "64. В Вашей жизни были случаи (может быть, только один), когда Вы чувствовали, что на Вас кто-то действует гипнозом."
            , "65. У Вас бывают периоды, во время которых Вы необычно веселы без особой причины."
            , "66. Даже находясь в обществе, Вы обычно чувствуете себя одиноко."
            , "67. Вы считаете, что почти каждый может солгать, чтобы избежать неприятностей."
            , "68. Вы чувствуете острее, чем большинство других людей."
            , "69. Временами Ваша голова работает как бы медленнее, чем обычно."
            , "70. Вы часто разочаровываетесь в людях. ", "71. Вы злоупотребляли спиртными напитками."};
    String answers = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smol);

        String q = getIntent().getStringExtra("q1112");
        res = q;
    }

    public void yes(View view) {
        answer = 1;
        findViewById(R.id.bno).setBackgroundResource(R.drawable.click_button);
        findViewById(R.id.byes).setBackgroundResource(R.drawable.warning_button_design_last);
    }

    public void no(View view) {
        answer = 2;
        findViewById(R.id.byes).setBackgroundResource(R.drawable.click_button);
        findViewById(R.id.bno).setBackgroundResource(R.drawable.warning_button_design_last);
    }

    public void startCheck(View view) {
        if (i == 70) {
            Intent intent = new Intent(this, MBTI.class);
            if (answer == 1)
                answers += "1";
            else
                answers += "0";
            intent.putExtra("q", res);
            intent.putExtra("smol", answers);
            startActivity(intent);
        }
        TextView textWarning = (TextView) findViewById(R.id.textViewError);
        if (answer == 0) {
            textWarning.setText("Вы не выбрали ответ");
        } else {
            textWarning.setText("");
            if (answer == 1)
                answers += "1";
            else
                answers += "0";
            i++;
            answer = 0;
            findViewById(R.id.byes).setBackgroundResource(R.drawable.click_button);
            findViewById(R.id.bno).setBackgroundResource(R.drawable.click_button);
            TextView textView = findViewById(R.id.question);
            textView.setText(questions[i]);
        }
    }
}