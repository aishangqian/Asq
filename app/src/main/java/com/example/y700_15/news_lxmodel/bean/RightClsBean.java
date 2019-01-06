package com.example.y700_15.news_lxmodel.bean;

import java.util.List;

public class RightClsBean {
    public String code;
    public String msg;
    public List<RightClsBean.Cls> data;

    public class Cls{

        public String pcid;
        public String name;
        public List<Pcls> list;

        public class Pcls{

            public String name;
            public String icon;
        }
    }
}
