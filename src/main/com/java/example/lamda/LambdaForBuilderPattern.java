package main.com.java.example.lamda;

import java.util.function.Consumer;

// Also called cascade method pattern
public class LambdaForBuilderPattern
{
    public static void main(String[] args)
    {
        Mailer m = Mailer.send(
                mailer -> mailer.from("abc@xyz.com").to("xyz@abc.com").subject("Subject").body("Body of the message"));

        System.out.println("Mesage From: " + m.getFrom());
    }
}

class Mailer
{
    private String from;

    public String getFrom()
    {
        return from;
    }

    public Mailer from(String from)
    {
        this.from = from;
        return this;
    }

    public Mailer to(String to)
    {
        System.out.println(to);
        return this;
    }

    public Mailer subject(String subject)
    {
        System.out.println(subject);
        return this;
    }

    public Mailer body(String body)
    {
        System.out.println(body);
        return this;
    }

    // return type was void, made it to return Mailer class to write getters
    public static Mailer send(Consumer<Mailer> block)
    {
        Mailer mailer = new Mailer();
        block.accept(mailer);

        return mailer;
    }
}
