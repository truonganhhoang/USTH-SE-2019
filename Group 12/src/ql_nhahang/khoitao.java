/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ql_nhahang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.*; 
/**
 *
 * @author lamct
 */
public class khoitao {
    public static void main(String[] args) throws SQLException, FileNotFoundException, IOException {
        String qkhoitao = "" + 
            "create database if not exists nhahang;\n" +
            "\n" +
            "use nhahang;\n" +
            "\n" +
            "\n" +
            "create table login(\n" +
            "	tendangnhap varchar(10) not null,\n" +
            "    matkhau varchar(8) not null,\n" +
            "    quenhan varchar(10),\n" +
            "    primary key (tendangnhap)\n" +
            ");\n" +
            "\n" +
            "create table nhanvien(\n" +
            "	id_nv tinyint auto_increment not null,\n" +
            "    ten_nv varchar(30) not null,\n" +
            "    gioitinh varchar(5),\n" +
            "    ngaysinh date,\n" +
            "    quequan varchar(50),\n" +
            "    cmnd varchar(10),\n" +
            "    sdt varchar(10),\n" +
            "    hesoluong tinyint,\n" +
            "    tendangnhap varchar(10),\n" +
            "    -- ngay lam viec\n" +
            "    t2 boolean default false,\n" +
            "    t3 boolean default false,\n" +
            "    t4 boolean default false,\n" +
            "    t5 boolean default false,\n" +
            "    t6 boolean default false,\n" +
            "    t7 boolean default false,\n" +
            "    cn boolean default false,\n" +
            "    \n" +
            "	primary key (id_nv),\n" +
            "    foreign key (tendangnhap) references login(tendangnhap)\n" +
            ");\n" +
            "\n" +
            "create table mathang(\n" +
            "	id_hang mediumint unsigned not null,\n" +
            "    tenmathang varchar(50) not null,\n" +
            "    chungloai varchar(50) not null,\n" +
            "    gia int not null,\n" +
            "    soluong smallint unsigned not null,\n" +
            "    primary key (id_hang)\n" +
            ");\n" +
            "\n" +
            "create table laphoadon(\n" +
            "	id_hoadon varchar(10) not null,\n" +
            "    thoigianlap TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,\n" +
            "    id_nv tinyint auto_increment not null,\n" +
            "    primary key (id_hoadon),\n" +
            "    foreign key (id_nv) references nhanvien(id_nv)\n" +
            ");\n" +
            "CREATE TABLE chitiethoadon (\n" +
            "    id_hoadon VARCHAR(10) NOT NULL,\n" +
            "    id_hang MEDIUMINT UNSIGNED NOT NULL,\n" +
            "    soluong SMALLINT UNSIGNED NOT NULL,\n" +
            "    FOREIGN KEY (id_hoadon)\n" +
            "        REFERENCES laphoadon (id_hoadon),\n" +
            "    FOREIGN KEY (id_hang)\n" +
            "        REFERENCES mathang (id_hang)\n" +
            ");\n" +
            "-- --\n" +
            "INSERT INTO `nhahang`.`login` (`tendangnhap`, `matkhau`, `quenhan`) VALUES ('u1', '1', '1');\n" +
            "INSERT INTO `nhahang`.`login` (`tendangnhap`, `matkhau`, `quenhan`) VALUES ('u2', '1', '1');\n" +
            "INSERT INTO `nhahang`.`login` (`tendangnhap`, `matkhau`, `quenhan`) VALUES ('u3', '1', '2');\n" +
            "INSERT INTO `nhahang`.`login` (`tendangnhap`, `matkhau`, `quenhan`) VALUES ('admin', '1', '3');\n" +
            "-- --\n" +
            "INSERT INTO `nhahang`.`nhanvien` (`id_nv`, `ten_nv`, `gioitinh`, `ngaysinh`, `quequan`, `cmnd`, `sdt`, `hesoluong`, `tendangnhap`, `t2`, `t3`, `t4`, `t5`, `t6`, `t7`, `cn`) VALUES ('1', 'Trang', 'Nữ', '1991-1-11', 'ha Nam', '123456789', '0987654321', '2', 'u1', '1', '1', '0', '0', '0', '0', '1');\n" +
            "INSERT INTO `nhahang`.`nhanvien` (`id_nv`, `ten_nv`, `gioitinh`, `ngaysinh`, `quequan`, `cmnd`, `sdt`, `hesoluong`, `tendangnhap`) VALUES ('2', 'Tâm', 'Nữ', '1991-01-11', 'Hà Nội', '123456777', '0988888888', '1.5', 'u2');\n" +
            "\n" +
            "-- --\n" +
            "\n" +
            "\n" +
            "-- --\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('001', 'Hồ lô chiên', 'Đồ ăn', '12000', '100');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('002', 'Thanh cua viên', 'Đồ ăn', '12000', '100');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('003', 'Thanh cua viên', 'Đồ ăn', '20000', '100');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('004', 'Bánh bao chay', 'Đồ ăn', '6000', '100');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('005', 'Bánh bao thịt', 'Đồ ăn', '12000', '100');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('006', 'Bánh bao xá xíu', 'Đồ ăn', '15000', '50');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('007', 'Nem chua rán', 'Đồ ăn', '4000', '200');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('008', 'Xúc xích rán', 'Đồ ăn', '10000', '200');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('009', 'Lạp xưởng', 'Đồ ăn', '8000', '200');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('010', 'Há cảo', 'Đồ ăn', '10000', '100');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('011', 'Chả cá', 'Đồ ăn', '10000', '50');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('012', 'Bánh tôm', 'Đồ ăn', '6000', '100');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('013', 'Cốm trứng', 'Đồ ăn', '10000', '50');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('014', 'Phô mai que', 'Đồ ăn', '5000', '100');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('015', 'Phô mai que cốm', 'Đồ ăn', '5000', '50');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('017', 'Sữa chua chiên giòn', 'Đồ ăn', '12000', '50');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('018', 'Bánh mì trứng', 'Đồ ăn', '10000', '50');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('019', 'Bánh mì thịt xiên', 'Đồ ăn', '10000', '30');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('020', 'Bánh mì bò khô', 'Đồ ăn', '9000', '30');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('021', 'Bánh mì trứng bate', 'Đồ ăn', '12000', '15');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('022', 'Bánh mì xúc xích', 'Đồ ăn', '15000', '15');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('023', 'Bánh mì trứng lá ngải', 'Đồ ăn', '10000', '15');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('024', 'Bánh mì trứng ruốc', 'Đồ ăn', '12000', '15');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('025', 'Bánh mì nhân ruốc', 'Đồ ăn', '6000', '20');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('026', 'Bánh mì gối', 'Đồ ăn', '10000', '10');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('027', 'Snack tôm', 'Đồ ăn', '5000', '20');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('028', 'Snack oishi', 'Đồ ăn', '5000', '20');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('029', 'Snack swing', 'Đồ ăn', '6000', '20');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('030', 'Snack hành', 'Đồ ăn', '5000', '20');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('031', 'Snack cua', 'Đồ ăn', '6000', '20');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('032', 'Snack ngô', 'Đồ ăn', '5000', '20');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('033', 'Snack khoai tây', 'Đồ ăn', '10000', '20');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('034', 'Snack poca', 'Đồ ăn', '5000', '20');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('035', 'Snackstar', 'Đồ ăn', '5000', '20');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('036', 'Snack indo chip', 'Đồ ăn', '5000', '20');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('037', 'Hạt sen chiên', 'Đồ ăn', '10000', '10');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('038', 'Bim bim que', 'Đồ ăn', '10000', '20');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('039', 'Ngô cay', 'Đồ ăn', '15000', '20');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('040', 'Khoai tây que', 'Đồ ăn', '10000', '10');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('041', 'Hướng hương', 'Đồ ăn', '5000', '20');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('042', 'Đậu phộng', 'Đồ ăn', '10000', '20');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('043', 'Bắp rang bơ', 'Đồ ăn', '5000', '20');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('044', 'Bắp rang cacao', 'Đồ ăn', '5000', '10');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('045', 'Bim bim thái', 'Đồ ăn', '20000', '10');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('046', 'Quẩy tôm', 'Đồ ăn', '15000', '10');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('047', 'Quẩy rong biển', 'Đồ ăn', '15000', '10');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('048', 'Heo khô', 'Đồ ăn', '15000', '10');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('049', 'Ô mai', 'Đồ ăn', '20000', '5');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('050', 'Bánh quy trứng muối', 'Đồ ăn', '10000', '10');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('051', 'Bánh gấu nhân kem', 'Đồ ăn', '15000', '10');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('052', 'Bánh cá mặn', 'Đồ ăn', '10000', '10');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('053', 'Chè thập cẩm', 'Đồ ăn', '15000', '15');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('054', 'Chè ngô', 'Đồ ăn', '10000', '15');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('055', 'Chè khoai', 'Đồ ăn', '10000', '10')	;\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('056', 'Chè thái', 'Đồ ăn', '10000', '10');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('057', 'Chè chân châu', 'Đồ ăn', '10000', '10');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('059', 'Tào phớ', 'Đồ ăn', '5000', '15');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('060', 'Sữa chua đánh đá', 'Đồ ăn', '10000', '10');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('061', 'Nước lọc', 'Đồ uống', '5000', '100');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('062', 'Sting', 'Đồ uống', '8000', '100');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('063', 'Coca', 'Đồ uống', '5000', '100');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('064', 'Pepsi', 'Đồ uống', '5000', '100');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('065', 'Nước cam', 'Đồ uống', '8000', '50');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('066', 'Trà chanh', 'Đồ uống', '5000', '50');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('077', 'Sữa dậu nành', 'Đồ uống', '5000', '20');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('067', 'Sữa milo', 'Đồ uống', '8000', '20');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('068', 'Trà bí đao', 'Đồ uống', '5000', '20');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('069', 'Trà đào', 'Đồ uống', '10000', '10');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('070', 'Nước dừa', 'Đồ uống', '20000', '10');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('071', '7 up', 'Đồ uống', '8000', '10');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('072', 'Chanh leo', 'Đồ uống', '8000', '10');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('073', 'Cafe đen', 'Đồ uống', '20000', '20');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('074', 'Cafe nâu', 'Đồ uống', '15000', '20');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('075', 'Trà ô long', 'Đồ uống', '12000', '20');\n" +
            "INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('076', 'Bò húc', 'Đồ uống', '15000', '20');";
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            try (Connection con = DriverManager.getConnection(  
                    "jdbc:mysql://localhost:3306/","root",Ql_nhahang.mysqlpass)) {
                Statement stmt=con.createStatement();
                String query = "show databases like 'nhahang'";
                ResultSet rs = stmt.executeQuery(query);                  
                rs.next();
                System.out.println(rs.getString(1));
                //int rs2=stmt.executeUpdate(qkhoitao);
                
            }  
        }catch(ClassNotFoundException | SQLException e){
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","ngkn.Newt123");
                Statement stmt=con.createStatement();
                int rs2=stmt.executeUpdate(qkhoitao);
            
            System.out.println(e);} 
    }
}
