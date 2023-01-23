package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MBTI_W extends AppCompatActivity {

    int answer = 0;
    int i = 0;
    String res = null;
    String smol = null;
    String[] questions = new String[] {"Вас больше привлекают ситуации  определенные и завершенные",
            "Вас больше привлекают ситуации неопределенные и незавершенные",
            "Вас больше привлекают ситуации  упорядоченные и распланированные",
            "Вас больше привлекают ситуации неупорядоченные и не распланированные",
            " Организованный",
            "Импульсивный",
            "Вам лучше удается следовать четко продуманному плану",
            " Вам лучше удается справляться с неожиданностями",
            " Решение",
            "Импульс",
            "Подготовка",
            "Экспромт",
            "Любите ли Вы, чтобы понятия были сформулированы предельно ясно?",
            "Вы не обращаете большого внимания на нерешенные вопросы?",
            "Общительный",
            "Сосредоточенный",
            "В компании Вы  инициатор разговора",
            "В компании Вы ждете, когда к Вам обратятся",
            "Вы любезны и оживлены в общении, много и охотно общаетесь?",
            "Вы с трудом запоминаете новые имена и лица? Вы избирательны в общении?",
            "Вы коммуникабельны, активно общаетесь, любите разнообразить свое окружение?",
            "Вы хорошо работаете в одиночку,  быстро устаете от общения?",
            "Когда Вы находитесь в обществе предпочитаете участвовать в общей беседе",
            "Когда Вы находитесь в обществе беседовать с каждым отдельно",
            "Обычно Вы общительный человек",
            "Обычно Вы  спокойный и сдержанный",
            "Среди Ваших друзей Вы полны новостей обо всех",
            "Среди Ваших друзей Вы последним узнаете о том, что происходит",
            "В большинстве случаев Вы человек практичный",
            "В большинстве случаев Вы человек с фантазией и прихотями",
            "Рассудительный",
            "Удивительный",
            "Вы бы предпочли, чтобы Вас считали практичным человеком",
            "Вы бы предпочли, чтобы Вас считали изобретательным человеком",
            "Практик",
            "Фантазер",
            "Вы больше интересуетесь реально существующим",
            "Вы больше интересуетесь возможным",
            "Вы в большей степени человек реалистичный",
            "Вы в большей степени человек склонный к теоретизированию",
            "Опыт",
            "Теории",
            "Эмоции не затрагивают Вас глубоко?",
            "Вы человек глубоких переживаний и чувств?",
            "Твердый",
            "Мягкосердечный",
            "Преимущество",
            "Удача",
            "Вы лучше разбираетесь в технологиях и структурах?",
            "Вы лучше разбираетесь в чувствах и отношениях?",
            "Вы охотнее анализируете и упорядочиваете?",
            "Вы  охотнее общаетесь с близкими людьми?",
            "Вы скорее человек  твердый, чем мягкий",
            "Вы скорее человек мягкий, чем твердый",
            "Считаете, что важнее быть правым, чем приятным",
            "Склонны к компромиссам в делах ради сохранения хороших отношений","",""};
    String answers = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mbti_w);

        String q = getIntent().getStringExtra("mbti");
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
        if (i == 27) {
            Intent intent = new Intent(this, Results.class);
            if (answer == 1)
                answers += "1";
            else
                answers += "0";
            res += " " + answers;
            intent.putExtra("mbti_w", res);
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
            Button b1 = (Button) findViewById(R.id.byes);
            b1.setText(questions[i * 2]);
            findViewById(R.id.bno).setBackgroundResource(R.drawable.click_button);
            Button b2 = (Button) findViewById(R.id.bno);
            b2.setText(questions[i * 2 + 1]);
        }
    }
}