package sh.parsers.eurotripsparser.mapper.kiwi;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.SystemUtils;
import org.springframework.stereotype.Component;
import sh.parsers.eurotripsparser.model.kiwi.Datum;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Component
public class MessageMapper {

    public String toMessage(Datum result){
        return "============================" +
                SystemUtils.LINE_SEPARATOR +
                "<b>DIRECT:</b>" +
                SystemUtils.LINE_SEPARATOR +
                "\t<b>FROM:</b>\t" + result.getCityFrom() + " (" + result.getFlyFrom() + ")" +
                SystemUtils.LINE_SEPARATOR +
                "\t<b>TO:</b>\t" + result.getCityTo() +
                SystemUtils.LINE_SEPARATOR +
                "\t<b>DATE FROM:</b>\t" + Instant.ofEpochMilli(result.getRoute().get(0).dTime * 1000).atZone(ZoneId.systemDefault()).toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) +
                SystemUtils.LINE_SEPARATOR +
                "\t<b>DATE TO:</b>\t" + Instant.ofEpochMilli(result.getRoute().get(0).aTime * 1000).atZone(ZoneId.systemDefault()).toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) +
                SystemUtils.LINE_SEPARATOR +
                "<b>RETURN:</b>" +
                SystemUtils.LINE_SEPARATOR +
                "\t<b>DATE FROM</b>:\t" + Instant.ofEpochMilli(result.getRoute().get(1).dTime * 1000).atZone(ZoneId.systemDefault()).toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) +
                SystemUtils.LINE_SEPARATOR +
                "\t<b>DATE TO</b>:\t" + Instant.ofEpochMilli(result.getRoute().get(1).aTime * 1000).atZone(ZoneId.systemDefault()).toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) +
                SystemUtils.LINE_SEPARATOR +
                "\t<b>PRICE:</b>\t" + result.getPrice() + " EUR" +
                SystemUtils.LINE_SEPARATOR +
                "============================";
    }
}
