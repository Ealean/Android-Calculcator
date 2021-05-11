package Tptogiar.calculcator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.TextViewCompat;

import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private StringBuilder currentInput=new StringBuilder("");
    private BigDecimal currentAnswer=new BigDecimal(0);
    private boolean hasCount=false;
    private TextView inputTextView,outputTextView;
    private Button btn_0,btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9,
            btn_point,btn_equal,btn_add,btn_subtract,btn_multiply,btn_divide,btn_percent,btn_backspace,btn_clear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setListener();
        TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(inputTextView, 10, 50, 2, TypedValue.COMPLEX_UNIT_SP);
        TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(outputTextView, 10, 50, 2, TypedValue.COMPLEX_UNIT_SP);
    }

    public void setListener(){
        inputTextView = (TextView)findViewById(R.id.inputText);
        outputTextView= (TextView)findViewById(R.id.outputText);

        btn_0 = (Button)findViewById(R.id.btn_0);
        btn_0.setOnClickListener(this);
        btn_1 = (Button)findViewById(R.id.btn_1);
        btn_1.setOnClickListener(this);
        btn_2 = (Button)findViewById(R.id.btn_2);
        btn_2.setOnClickListener(this);
        btn_3 = (Button)findViewById(R.id.btn_3);
        btn_3.setOnClickListener(this);
        btn_4 = (Button)findViewById(R.id.btn_4);
        btn_4.setOnClickListener(this);
        btn_5 = (Button)findViewById(R.id.btn_5);
        btn_5.setOnClickListener(this);
        btn_6 = (Button)findViewById(R.id.btn_6);
        btn_6.setOnClickListener(this);
        btn_7 = (Button)findViewById(R.id.btn_7);
        btn_7.setOnClickListener(this);
        btn_8 = (Button)findViewById(R.id.btn_8);
        btn_8.setOnClickListener(this);
        btn_9 = (Button)findViewById(R.id.btn_9);
        btn_9.setOnClickListener(this);
        btn_point = (Button)findViewById(R.id.btn_point);
        btn_point.setOnClickListener(this);
        btn_equal = (Button)findViewById(R.id.btn_equal);
        btn_equal.setOnClickListener(this);
        btn_add = (Button)findViewById(R.id.btn_add);
        btn_add.setOnClickListener(this);
        btn_subtract = (Button)findViewById(R.id.btn_subtract);
        btn_subtract.setOnClickListener(this);
        btn_multiply = (Button)findViewById(R.id.btn_multiply);
        btn_multiply.setOnClickListener(this);
        btn_divide = (Button)findViewById(R.id.btn_divide);
        btn_divide.setOnClickListener(this);
        btn_backspace = (Button)findViewById(R.id.btn_backspace);
        btn_backspace.setOnClickListener(this);
        btn_clear = (Button)findViewById(R.id.btn_clear);
        btn_clear.setOnClickListener(this);
    }

    public void displayInput(){
        inputTextView.setText(currentInput);
    }

    public void displayAnswer(StringBuilder string){
        Pattern compile = Pattern.compile( "[^0-9.-]");
        StringBuilder result = new StringBuilder(compile.matcher(string).replaceAll(""));
        if(result.charAt(result.length()-1)=='-'){
            System.out.println(result.charAt(result.length()-1));
            result.deleteCharAt(result.length()-1);
        }
        System.out.println(result);
        outputTextView.setText(result);
    }

    public StringBuilder compute(StringBuilder str){
        Pattern pattern = Pattern.compile("([\\d.]+)\\s*([*/])\\s*([\\d.]+)");
        Matcher matcher=pattern.matcher(str.toString());
        while(matcher.find()){
            BigDecimal first = BigDecimal.valueOf(Double.valueOf(matcher.group(1)));
            BigDecimal second = BigDecimal.valueOf(Double.valueOf(matcher.group(3)));
            switch (matcher.group(2)){
                case "*":
                    first=first.multiply(second);
                    break;
                case "/":
                    first=first.divide(second);
                    break;
            }
            str.replace(matcher.start(),matcher.end(),first.toString());
            matcher.reset(str.toString());
        }

        pattern = Pattern.compile("([\\d.]+)\\s*([+-])\\s*([\\d.]+)");
        matcher=pattern.matcher(str.toString());
        while (matcher.find()){
            BigDecimal first = BigDecimal.valueOf(Double.valueOf(matcher.group(1)));
            BigDecimal second = BigDecimal.valueOf(Double.valueOf(matcher.group(3)));
            switch(matcher.group(2)){
                case "+":
                    first=first.add(second);
                    break;
                case "-":
                    first=first.subtract(second);
                    break;

            }
            str.replace(matcher.start(),matcher.end(),first.toString());
            matcher.reset(str.toString());
        }
        return str;
    }
    public void addInput(String string){
        if(hasCount==false){
            currentInput.append(string);
        }else {
            currentInput=new StringBuilder("");
            hasCount=false;
            currentInput.append(string);
        }
        displayInput();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_0:
                addInput("0");
                break;
            case R.id.btn_1:
                addInput("1");
                break;
            case R.id.btn_2:
                addInput("2");
                break;
            case R.id.btn_3:
                addInput("3");
                break;
            case R.id.btn_4:
                addInput("4");
                break;
            case R.id.btn_5:
                addInput("5");
                break;
            case R.id.btn_6:
                addInput("6");
                break;
            case R.id.btn_7:
                addInput("7");
                break;
            case R.id.btn_8:
                addInput("8");
                break;
            case R.id.btn_9:
                addInput("9");
                break;
            case R.id.btn_point:
                addInput(".");
                break;
            case R.id.btn_add:
                addInput("+");
                break;
            case R.id.btn_subtract:
                addInput("-");
                break;
            case R.id.btn_multiply:
                addInput("*");
                break;
            case R.id.btn_divide:
                addInput("/");
                break;
            case R.id.btn_backspace:
                if(currentInput.length()>0){
                    currentInput.deleteCharAt(currentInput.length()-1);
                }
                displayInput();
                break;
            case R.id.btn_clear:
                currentInput=new StringBuilder("");
                displayInput();
                outputTextView.setText("");
                break;
            case R.id.btn_equal:
                StringBuilder result = compute(currentInput);
                displayAnswer(result);
                hasCount=true;
                break;
        }
    }
}