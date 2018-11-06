package com.page.mobilium;

import java.util.ArrayList;

public class Application {

    public static String urunGorseli = "file:///android_asset/images/urun.png";

    public static ArrayList<DataList> products = new ArrayList<DataList>() {{
        add(new DataList("file:///android_asset/images/asagi_ok.png","Ürün Bilgisi",null));
        add(new DataList("file:///android_asset/images/asagi_ok.png","Ürün Açıklaması",null));
        add(new DataList("file:///android_asset/images/sag_ok.png","İade ve Değişim",null));
        add(new DataList("file:///android_asset/images/sag_ok.png","Beden Tablosu",null));
    }};

    public static ArrayList<DataList> productsGrid = new ArrayList<DataList>() {{
        add(new DataList("file:///android_asset/images/resim1.png","Sırtı Bağlama Çanta","53,00TL"));
        add(new DataList("file:///android_asset/images/resim2.png","Boncuk Detaylı Ayakkabı","48,00TL"));
        add(new DataList("file:///android_asset/images/resim3.png","Sırtı Bağlama Çanta","53,00TL"));
        add(new DataList("file:///android_asset/images/resim4.png","Boncuk Detaylı Ayakkabı","48,00TL"));
    }};

    public static ArrayList<DataList> productsPager = new ArrayList<DataList>() {{
        add(new DataList("file:///android_asset/images/resim5.png","Sırtı Bağlama Çanta","53,00TL"));
        add(new DataList("file:///android_asset/images/resim6.png","Boncuk Detaylı Ayakkabı","48,00TL"));
        add(new DataList("file:///android_asset/images/resim5.png","Sırtı Bağlama Çanta","53,00TL"));
        add(new DataList("file:///android_asset/images/resim6.png","Boncuk Detaylı Ayakkabı","48,00TL"));
    }};

    public static ArrayList<DataList> entityList = new ArrayList<DataList>() {{
        add(new DataList("file:///android_asset/images/alaisveris.png","Alışverişini 500 TL’ ye tamamla 50 TL kazan",null));
        add(new DataList("file:///android_asset/images/degisim_iade.png","90 gün değişim ve iade",null));
        add(new DataList("file:///android_asset/images/guvenlialisveris.png","7/24 güvenli alışveriş",null));
        add(new DataList("file:///android_asset/images/taksit.png","Taksit seçenekleri",null));
        add(new DataList("file:///android_asset/images/kargo.png","100 TL ve üzeri alışverişlerde ücretsiz kargo",null));
    }};

}
