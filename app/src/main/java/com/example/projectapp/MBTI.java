package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Vector;

public class MBTI extends AppCompatActivity {

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
            "Склонны к компромиссам в делах ради сохранения хороших отношений",
            "Когда Вы знаете, что в определенное время будете заниматься определенным делом, Вы рады, что можете спланировать свое время",
            "Когда Вы знаете, что в определенное время будете заниматься определенным делом, Вам неприятно, что Вы чем-то связаны ",
            "Вы более склонны к продуманному поведению ",
            "Вы более склонны к спонтанному поведению",
            "План",
            "Импровизация",
            "Для Вас лучше, если все продумать заранее?    ",
            "Лучше, если Вы поступаете по ситуации?",
            "Если Вы действуете по плану, это нравится Вам ",
            "Если Вы действуете по плану, это стесняет и ограничивает Вас",
            "Вы лучше себя чувствуете  после принятия решения ",
            "Вы лучше себя чувствуете до принятия решения",
            "Вы больше цените в ситуации  ясность",
            "Вы больше цените в ситуации  неизвестность",
            "Новое и необычное взаимодействие с людьми стимулирует Вас и наполняет энергией ",
            "Новое и необычное взаимодействие с людьми утомляет Вас и расходует энергию",
            "Контакты с незнакомыми не напрягают Вас?",
            "Контакты с незнакомыми требуют усилий?",
            "Вам присуща смелость, импульсивность, решительность. ",
            "Вам свойственны сдержанность и осторожность в высказываниях. ",
            "Моя  деятельность скорее растет, чем углубляется?   ",
            "Моя  деятельность скорее углубляется чем растет?",
            "Вы считаете, что близкие к Вам люди знают Ваше мнение по поводу большинства вещей",
            "Вы считаете, что близкие к Вам люди знают Ваше мнение только если Вы сообщите его им ",
            "Вы любите разнообразие и действие?",
            "Вы любите сосредоточенность и тишину? ",
            "Ориентированный во внешний мир",
            "Ориентированный внутрь себя",
            "С Вашей практичностью никогда не пропадете?",
            "Ваша непрактичность беспокоит  ваших  близких?",
            "Вас больше привлекают  реалисты",
            "Привлекают  люди с богатым воображением",
            "Хуже \"витать в облаках\"",
            "Хуже \"катиться по накатанной колее\" ",
            "Вы больше доверяете своему опыту ",
            "Вы больше доверяете своей интуиции",
            "Если ничего не ясно, собираете сведенья?",
            "Если ничего не ясно, полагаюсь на интуицию?",
            "Вы внимательны  и точны с фактами?",
            "Вы нередко делаете фактические ошибки?",
            "Фактический",
            "Теоретический",
            "Окружающие больше ценят Вашу логичность?",
            "Окружающие больше ценят Вашу человечность?",
            "Вы человек  хладнокровный и спокойный",
            "Чаще Вы человек сердечный и участливый",
            "Принципы",
            "Эмоции",
            "Вы любите анализировать и устанавливать  логический порядок? ",
            "Вы стремитесь к гармоничным отношениям с людьми?",
            "Вас больше привлекает последовательность и логичность рассуждении ",
            "Вас больше привлекает гармоничность человеческих отношений ",
            "Ваши суждения о людях основаны на правилах чаще, чем на обстоятельствах ",
            "Ваши суждения о людях основаны на обстоятельствах чаще, чем на правилах",
            "Склонный к критике",
            "Доброжелательный",
            "",
            ""};
    ArrayList<Integer> answers = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mbti);

        String q = getIntent().getStringExtra("q12w");
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

    public void startCheck(View view) throws JSONException {
        if (i == 55) {
            Intent intent = new Intent(this, MBTI_W.class);
            if (answer == 1)
                answers.add(1);
            else
                answers.add(2);
            JSONObject json = new JSONObject(res);
            JSONObject big_json = new JSONObject();
            JSONObject cur_json = new JSONObject();
            big_json.put("famaly_love_quiz", json);
            JSONArray json_answers = new JSONArray();
            for (int k = 0; k < 7; k++) {
                json_answers.put(answers.get(0));
                answers.remove(0);
            }
            cur_json.put("first_organizing", json_answers);
            json_answers = new JSONArray();
            for (int k = 0; k < 7; k++) {
                json_answers.put(answers.get(0));
                answers.remove(0);
            }
            cur_json.put("first_communicability", json_answers);
            json_answers = new JSONArray();
            for (int k = 0; k < 7; k++) {
                json_answers.put(answers.get(0));
                answers.remove(0);
            }
            cur_json.put("first_practicality", json_answers);
            json_answers = new JSONArray();
            for (int k = 0; k < 7; k++) {
                json_answers.put(answers.get(0));
                answers.remove(0);
            }
            cur_json.put("first_logicality", json_answers);
            json_answers = new JSONArray();
            for (int k = 0; k < 7; k++) {
                json_answers.put(answers.get(0));
                answers.remove(0);
            }
            cur_json.put("second_organizing", json_answers);
            json_answers = new JSONArray();
            for (int k = 0; k < 7; k++) {
                json_answers.put(answers.get(0));
                answers.remove(0);
            }
            cur_json.put("second_communicability", json_answers);
            json_answers = new JSONArray();
            for (int k = 0; k < 7; k++) {
                json_answers.put(answers.get(0));
                answers.remove(0);
            }
            cur_json.put("second_practicality", json_answers);
            json_answers = new JSONArray();
            for (int k = 0; k < 7; k++) {
                json_answers.put(answers.get(0));
                answers.remove(0);
            }
            cur_json.put("second_logicality", json_answers);

            big_json.put("mbti_quiz_male", cur_json);
            System.out.println(big_json);
            intent.putExtra("mbti", big_json.toString());
            startActivity(intent);
        }
        TextView textWarning = (TextView) findViewById(R.id.textViewError);
        if (answer == 0) {
            textWarning.setText("Вы не выбрали ответ");
        } else {
            textWarning.setText("");
            if (answer == 1)
                answers.add(1);
            else
                answers.add(2);
            i++;
            answer = 0;
            findViewById(R.id.byes).setBackgroundResource(R.drawable.click_button);
            Button b1 = (Button) findViewById(R.id.byes);
            if (i < 55) {
                TextView textCount = (TextView) findViewById(R.id.textViewCount);
                textCount.setText(Integer.toString(i + 1) + "/56");
                b1.setText(questions[i * 2]);
                findViewById(R.id.bno).setBackgroundResource(R.drawable.click_button);
                Button b2 = (Button) findViewById(R.id.bno);
                b2.setText(questions[i * 2 + 1]);
            }
        }
    }
}