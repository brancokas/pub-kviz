package hr.fer.progi.pubkvizovi.domain;

import java.util.ArrayList;
import java.util.List;

public enum KnowledgeArea {
        FILM(0),
        MUSIC(1),
        LITERATURE(2),
        SPORT(3),
        HISTORY(4),
        GEOGRAPHY(5),
        MYTHOLOGY(6),
        SCIENCE(7),
        ART(8),
        RELIGION(9),
        LIFESTYLE(10),
        FUN(11),
        TRIVIA(12);

        private Integer value;

        KnowledgeArea(Integer value) {
                this.value = value;
        }

        public static List<KnowledgeArea> getKnowledgeAreas(String knowledgeAreas) {
                List<KnowledgeArea> knowledgeAreaList = new ArrayList<>();

                knowledgeAreas = knowledgeAreas.substring(1, knowledgeAreas.length() - 1);

                String[] areas = knowledgeAreas.split(",");
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < areas.length; i++)
                        list.add(Integer.parseInt(areas[i].trim()));

                for (KnowledgeArea kA : KnowledgeArea.values())
                        if (list.contains(kA.value))
                                knowledgeAreaList.add(kA);

                return knowledgeAreaList;
        }

}