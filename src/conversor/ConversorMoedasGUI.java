
package conversor;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.MessageFormat;
import java.util.*;

public class ConversorMoedasGUI extends JFrame {
    private static final String[] MOEDAS = {"ARS", "BOB", "BRL", "CLP", "COP", "USD", "PYG", "PEN", "UYU", "VES"};
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/12c23be4f9f75d9170e67b9b/latest/";

    private ResourceBundle mensagens;

    private JComboBox<String> comboIdioma;
    private JComboBox<String> comboBase;
    private JComboBox<String> comboDestino;
    private JTextField campoValor;
    private JButton botaoConverter;
    private JLabel labelResultado;

    public ConversorMoedasGUI() {
        setTitle("Conversor de Moedas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(6, 2, 10, 10));

        comboIdioma = new JComboBox<>(new String[]{"pt", "en", "es"});
        comboBase = new JComboBox<>(MOEDAS);
        comboDestino = new JComboBox<>(MOEDAS);
        campoValor = new JTextField();
        botaoConverter = new JButton("Converter");
        labelResultado = new JLabel("");

        painel.add(new JLabel("Idioma:"));
        painel.add(comboIdioma);
        painel.add(new JLabel("Moeda base:"));
        painel.add(comboBase);
        painel.add(new JLabel("Moeda destino:"));
        painel.add(comboDestino);
        painel.add(new JLabel("Valor:"));
        painel.add(campoValor);
        painel.add(botaoConverter);
        painel.add(new JLabel("Resultado:"));
        painel.add(labelResultado);

        add(painel);

        comboIdioma.addActionListener(e -> carregarMensagens());
        botaoConverter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                converterMoeda();
            }
        });

        carregarMensagens(); // carrega mensagens iniciais em pt
    }

    private void carregarMensagens() {
        String lang = (String) comboIdioma.getSelectedItem();
        Locale locale = switch (lang) {
            case "en" -> Locale.ENGLISH;
            case "es" -> new Locale("es");
            default -> new Locale("pt");
        };
        mensagens = ResourceBundle.getBundle("conversor.messages", locale);
        botaoConverter.setText(mensagens.getString("menu.title"));
    }

    private void converterMoeda() {
        String base = (String) comboBase.getSelectedItem();
        String destino = (String) comboDestino.getSelectedItem();

        if (base.equals(destino)) {
            labelResultado.setText("-");
            return;
        }

        double valor;
        try {
            valor = Double.parseDouble(campoValor.getText());
        } catch (NumberFormatException e) {
            labelResultado.setText("Valor inválido");
            return;
        }

        double taxa = obterTaxaDeCambio(base, destino);
        if (taxa != -1) {
            double convertido = valor * taxa;
            String msg = MessageFormat.format(mensagens.getString("output.result"), valor, base, convertido, destino);
            labelResultado.setText(msg);
        } else {
            labelResultado.setText(mensagens.getString("output.error"));
        }
    }

    private double obterTaxaDeCambio(String base, String destino) {
        try {
            String url = API_URL.replace("SUA_API_KEY", "12c23be4f9f75d9170e67b9b") + base;
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
            JsonObject taxas = jsonObject.getAsJsonObject("conversion_rates");
            return taxas.get(destino).getAsDouble();
        } catch (Exception e) {
            return -1;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ConversorMoedasGUI().setVisible(true));
    }
}
