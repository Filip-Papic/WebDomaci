package app;

import com.google.gson.Gson;
import http.Request;
import http.response.HtmlResponse;
import http.response.Response;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuoteController extends Controller {

    public static List<String> quotes = new ArrayList<>(){{
        add("T.S. Elliot: " + '"' + "Be who you needed when you were younger." + '"');
        add("Glennon Doyle Melton: " + '"' + "Be messy and complicated and afraid and show up anyways." + '"');
        add("Ralph Waldo Emerson: " + '"' + "There is a tendency for things to right themselves." + '"');
    }};

    private BufferedReader in;
    private PrintWriter out;
    private String qod, requestLine;
    Gson gson = new Gson();

    public QuoteController(Request request) {
        super(request);
    }

    @Override
    public Response doGet() {
        Random rand = new Random();
        String s = quotes.get(rand.nextInt(quotes.size()));
        return new HtmlResponse(s);
    }

    @Override
    public Response doPost() {
        //return new RedirectResponse("/quotes");
        return null;
    }
}
