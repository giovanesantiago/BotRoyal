package controller.Bot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.util.ArrayList;

public class ControllerBot {

    WebDriver driver;
    ArrayList<String> telefones;
    String message;

    public ControllerBot(ArrayList<String> telefones, String message) {
        this.telefones = telefones;
        this.message = message;
    }

    public void inciarBot() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        // Abrindo web whats
        driver.get("https://web.whatsapp.com/");
        JOptionPane.showMessageDialog(null, "1 - Faça leitura do qrcode \n" +
                "2 - Espera o carregamento completo do web whatsapp \n" +
                "3 - Aperte ok ");
        for (String telefone: telefones) {
            try {
                Thread.sleep(1000);
                driver.get("https://web.whatsapp.com/send/?phone=55" + telefone);
                Thread.sleep(15000);
                driver.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span[2]/div/div[2]" +
                        "/div[1]/div/div[1]/p")).click();
                Thread.sleep(700);
                String[] arrayTxt = message.split("");
                driver.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span[2]" +
                        "/div/div[2]/div[1]/div/div[1]/p")).sendKeys(arrayTxt[0]);
                for (int i = 1; i < message.length(); i++) {
                    driver.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span[2]/div/" +
                            "div[2]/div[1]/div/div/p/span")).sendKeys(arrayTxt[i]);

                    Thread.sleep(25);
                }
                Thread.sleep(1000);
                driver.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span" +
                        "[2]/div/div[2]/div[2]/button")).click();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                JOptionPane.showMessageDialog(null, "Error ao " +
                        "iniciar bot", "Error", 0);
            }

        }

        driver.quit();

    }
}

// Message : Ola eu sou giovane