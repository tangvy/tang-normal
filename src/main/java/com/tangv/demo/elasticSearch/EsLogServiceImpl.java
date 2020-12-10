package com.tangv.demo.elasticSearch;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/6/11 10:50 上午
 */

@RestController
public class EsLogServiceImpl {

    @Autowired
    private IesRepository iesRepository;

    public static final DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    @PostMapping("/add")
    public void addEsLog(@RequestParam String message) {

        MoEsLog moEsLog = new MoEsLog();
        moEsLog.setDateTime(df.format(LocalDateTime.now()));
        moEsLog.setMessage(message);
        iesRepository.save(moEsLog);
    }
    
    @PostMapping("/findAll")
    public List<MoEsLog> findEsLog() {
        Iterable<MoEsLog> all = iesRepository.findAll();
        ArrayList<MoEsLog> moEsLogs = Lists.newArrayList(all);
        return moEsLogs;
    }

    @PostMapping("/deleteAll")
    public void deleteAll() {
        iesRepository.deleteAll();
    }

    @PostMapping("/addAll")
    public void addAll() {
        List<MoEsLog> list = new LinkedList<>();
        for (int i = 101;i < 201;i++) {
            String message = "第"+i+"条数据";
            String time = df.format(LocalDateTime.now());
            MoEsLog moEsLog = new MoEsLog();
            moEsLog.setMessage(message);
            moEsLog.setDateTime(time);
            list.add(moEsLog);
            //iesRepository.save(moEsLog);
        }
        iesRepository.saveAll(list);
    }

    @PostMapping("/findLike")
    public List<MoEsLog> findLike(@RequestParam String message) {
        List<MoEsLog> list = iesRepository.findByMessageLike(message);
        return list;
    }

}
