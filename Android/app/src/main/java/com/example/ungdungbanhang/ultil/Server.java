package com.example.ungdungbanhang.ultil;

public class Server {

    //TriTue
    //public static String localhost ="192.168.1.15";
//   public static String localhost ="192.168.56.1:8080";

   // public static String localhost ="10.0.3.2:8080";

   public static String localhost ="192.168.1.92:80";

    public static String duongDanLoaiSanPham ="http://"+ localhost +"/Server/getloaisanpham.php";
    public static String duongDanSanPhamMoiNhat="http://"+ localhost+ "/Server/getsanphammoinhat.php";
    public static String duongDanGiay = "http://"+ localhost+ "/Server/getsanpham.php?page=";
    public static String duongDanSanPhamFlashSale = "http://"+ localhost+ "/Server/getsanphamflashsale.php";
    public static String duongDanThongTinKhachHang ="http://"+ localhost +"/Server/thongtinkhachhang.php";
    public static String duongDanChiTietDonHang ="http://"+ localhost +"/Server/chitietdonhang.php";
    public static String signup ="http://"+ localhost +"/Server/signup.php";
    public static String signin ="http://"+ localhost +"/Server/signin.php";

 }
