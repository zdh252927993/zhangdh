package com.zhangdh.jobflow.core;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.flowable.bpmn.converter.BpmnXMLConverter;
import org.flowable.bpmn.model.BpmnModel;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;

@Slf4j
public class BpmnConverter {
    private static final BpmnXMLConverter CONVERTER = new BpmnXMLConverter();
    private static final XMLInputFactory xif;

    static {
        xif = XMLInputFactory.newInstance();
        xif.setProperty(XMLInputFactory.SUPPORT_DTD, false);
    }

    public static BpmnModel convert2Model(InputStream is) throws XMLStreamException {
        InputStreamReader in = new InputStreamReader(is, StandardCharsets.UTF_8);
        XMLStreamReader xtr = xif.createXMLStreamReader(in);
        return CONVERTER.convertToBpmnModel(xtr);
    }

    public static String convert2XmlStr(BpmnModel model) {
        return new String(CONVERTER.convertToXML(model), StandardCharsets.UTF_8);
    }

    public static void main(String[] args) {
        try {
            InputStream in = new FileInputStream(Paths.get("/Users/zhangdh/IdeaProjects/yinshi/zhangdh/zhangdh-jobflow/zhangdh-jobflow-core/src/main/resources/processes/staff_leave.bpmn20.xml").toFile());
            BpmnModel bpmnModel = convert2Model(in);
            log.info(JSON.toJSONString(bpmnModel.getNamespaces()));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

    }
}
