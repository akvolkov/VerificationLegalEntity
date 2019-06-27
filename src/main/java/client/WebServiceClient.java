package client;

import unisoft.ws.FNSNDSCAWS2;
import unisoft.ws.FNSNDSCAWS2Port;
import unisoft.ws.fnsndscaws2.request.NdsRequest2;
import unisoft.ws.fnsndscaws2.response.NdsResponse2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Класс, реализующий консольное приложение, выполняющее запрос к API http://npchk.nalog.ru/
 * На вход приложению подается ИНН ЮЛ/ФЛ. Приложение возвращает один из возможных вариантов признака состояния
 * описанных в документации (ws2.doc). Дата сделки - текущая дата.
 */
public class WebServiceClient {
    public static void main(String[] args) throws IOException {
        String inn = "";
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            Boolean flag = true;
            while (flag) {
                System.out.print("Enter inn: ");
                inn = reader.readLine();
                if (UtilINN.checkNumber(inn) && UtilINN.checkLength(inn)) {
                    flag = false;
                }
            }
        }
        // создаем налогоплательщика
        NdsRequest2.NP np = new NdsRequest2.NP();
        np.setINN(inn);
        // np.setKPP("770901001");
        // КПП может нужен? без указания ответ для ЮЛ будет не всегда корректен.
        // Например, значения 0 никогда не получим для ЮЛ.
        np.setDT(new SimpleDateFormat("dd.MM.yyyy").format(new Date()));
        // создаем запрос
        NdsRequest2 ndsRequest2 = new NdsRequest2();
        ndsRequest2.getNP().add(np);
        // получаем ответ
        FNSNDSCAWS2Port fnsndscaws2Port = new FNSNDSCAWS2().getFNSNDSCAWS2Port();
        NdsResponse2 ndsResponse2 = fnsndscaws2Port.ndsRequest2(ndsRequest2);
        System.out.println(ndsResponse2.getNP().get(0).getState());
    }
}
