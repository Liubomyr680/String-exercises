import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextGenerator {

    private String text = "You vexed shy mirth now noise. Talked him people valley add use her depend letter. Allowance too applauded now way something recommend. Mrs age men and trees jokes fancy. Gay pretended engrossed eagerness continued ten. Admitting day him contained unfeeling attention mrs out. \n" +
            "\n" +
            "Much did had call new drew that kept. Limits expect wonder law she. Now has you views woman noisy match money rooms. To up remark it eldest length oh passed. Off because yet mistake feeling has men. Consulted disposing to moonlight ye extremity. Engage piqued in on coming. \n" +
            "\n" +
            "Yourself off its pleasant ecstatic now law 2003-12-25 . Ye their mirth seems of songs. Prospect out bed contempt separate. Her inquietude our shy yet sentiments collecting. Cottage fat beloved himself arrived old. Grave widow hours among him \uFEFFno you led. Power had these met least nor young. Yet match drift wrong his our. \n" +
            "\n" +
            "On recommend tolerably my belonging or am. Mutual has cannot beauty indeed now sussex merely you. It possible no husbands jennings ye offended packages pleasant he. Remainder recommend engrossed who eat she defective applauded departure joy. Get dissimilar not introduced day her apartments. Fully as taste he mr do smile abode every. Luckily offered article led lasting country minutes nor old. Happen people things oh is oppose up parish effect. Law handsome old outweigh humoured far appetite. \n" +
            "\n" +
            "Continual delighted as 1994 elsewhere am convinced unfeeling. Introduced stimulated attachment no by projection. To loud lady whom my mile sold four. Need miss all four case fine age tell. He families my pleasant speaking it bringing it thoughts. View busy dine oh in knew if even. Boy these along far own other equal old fanny charm. Difficulty invitation put introduced see middletons nor preference. \n" +
            "\n" +
            "Tolerably earnestly middleton extremely distrusts she boy now not. Add and offered prepare how cordial two promise. Greatly who affixed suppose but enquire compact prepare all put. Added forth chief trees but rooms think may. Wicket do manner others seemed enable rather in. Excellent own discovery unfeeling sweetness questions the gentleman. Chapter shyness matters mr parlors if mention thought. \n" +
            "\n" +
            "He as compliment unreserved projecting. Between had observe pretend delight for believe. Do newspaper questions consulted sweetness do. Our sportsman his unwilling fulfilled departure law. Now world own total saved above her cause table. Wicket myself her square remark the should far secure sex. Smiling cousins warrant law explain for whether. \n" +
            "\n" +
            "Boy favourable day can introduced sentiments entreaties. Noisier carried of in warrant because. So mr plate seems cause chief widen first. Two differed husbands met screened his. Bed was form wife out ask draw. Wholly coming at we no enable. Offending sir delivered questions now new met. Acceptance she interested new boisterous day discretion celebrated. \n" +
            "\n" +
            "Saw yet kindness too replying whatever marianne. Old sentiments resolution admiration unaffected its mrs literature. Behaviour new set existence dashwoods. It satisfied to mr commanded consisted disposing engrossed. Tall snug do of till on easy. Form not calm new fail. \n" +
            "\n" +
            "Frankness applauded by supported ye household. Collected favourite now for for and rapturous repulsive consulted. An seems green be wrote again. She add what own only like. Tolerably we as extremity exquisite do commanded. Doubtful offended do entrance of landlord moreover is mistress in. Nay was appear entire ladies. Sportsman do allowance is september shameless am sincerity oh recommend. Gate tell man day that who. \n";

    //Порахувати скільки в тексті є слів довжиною 3,5,7 символів
    public void wordCounter(){
        int count3 = 0;
        int count5 = 0;
        int count7 = 0;

        for(String i : text.split("[\\s]")){
            if(i.length() == 3){
                count3++;
            }else if(i.length() == 5){
                count5++;
            }else if(i.length() == 7){
                count7++;
            }
        }

        System.out.println("\nIn this text we have\n" +
                count3 + " words with 3 characters \n" +
                count5 + " words with 5 characters\n" +
                count7 + " words with 7 characters");
    }
    //Порахувати скільки в тексті є речень
    public void sentenceCounter(){
        
        System.out.println("\nIn this text " + text.split("[.]").length + " sentences");
    }

    //Кожне друге речення повинно бути переведено до верхнього регістру
    public void upperCaseConverter(){

        String[] str = text.split("[.]");

        for(int i = 0; i < str.length; i++){
            if(i % 2 == 0)
                str[i] = str[i].toUpperCase();
        }

        for(String i : str){
            System.out.println(i);
        }
    }

    //В кожному третьому ресченні голосна буква повинна бути приголосна
    public void latterChanger(){

        String[] str = text.split("[.]");

        for(int i = 0; i < str.length; i++){
            if(i % 3 == 0)
                str[i] = str[i].replace('a', 'B');
        }

        for(String i : str){
            System.out.println(i);
        }
    }

    // Обєднати три останні речення розділивши їх комою
    public void sentenceConcat(){
        String[] str = text.split("[.]");
        String strBuff = "";

        int i = str.length - 4;

        while(i < str.length-1){
            strBuff += str[i];
            strBuff += ",";
            i++;
        }

        StringBuilder builder = new StringBuilder(strBuff);
        builder.deleteCharAt(0);
        builder.deleteCharAt(strBuff.length()-2);
        strBuff = builder.toString();

        System.out.println(strBuff);
    }

    //Знайти скільки в тексті є дат відповідного формату
    public void dateSearcher(){
        int yearFormatCounter = 0;
        int yy_mm_ddFormatCounter = 0;

        for(String i : text.split("[\\s]")){
            if(i.matches("[0-9]{4}"))
                yearFormatCounter++;

            if(i.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}"))
                yy_mm_ddFormatCounter++;
        }

        System.out.println("We found " + yearFormatCounter + " date format yy");
        System.out.println("We found " + yy_mm_ddFormatCounter+ " date format yy-mm-dd");
    }

    //Порахувати суму всіх чисел в тексті
    public void sumOfAllDigitsInText(){

        Pattern p = Pattern.compile("(\\d+)");
        Matcher m = p.matcher(text);
        Integer sum = 0;
        while (m.find()) {
            sum += Integer.parseInt(m.group(1));
        }
        System.out.printf("%d\n", sum);
    }

    //Останнє речення виводить задом на перед
    public void lastSentenceReverse(){

        String[] str = text.split("[.]");
        String[] temp = str[str.length-2].split("[\\s]");
        String lastSentenceStr = "";

        for(int i = temp.length; i > 0; i--){
            lastSentenceStr += temp[i-1] + " ";
        }

        System.out.println(lastSentenceStr);
    }
}
