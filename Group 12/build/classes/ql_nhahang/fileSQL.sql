/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  lamct
 * Created: 20-Dec-2018
 */

create database if not exists nhahang;

use nhahang;


create table login(
	tendangnhap varchar(10) not null,
    matkhau varchar(8) not null,
    quenhan varchar(10),
    primary key (tendangnhap)
);

create table nhanvien(
	id_nv tinyint auto_increment not null,
    ten_nv varchar(30) not null,
    gioitinh varchar(5),
    ngaysinh date,
    quequan varchar(50),
    cmnd varchar(10),
    sdt varchar(10),
    hesoluong tinyint,
    tendangnhap varchar(10),
    -- ngay lam viec
    t2 boolean default false,
    t3 boolean default false,
    t4 boolean default false,
    t5 boolean default false,
    t6 boolean default false,
    t7 boolean default false,
    cn boolean default false,
    
	primary key (id_nv),
    foreign key (tendangnhap) references login(tendangnhap)
);

create table mathang(
	id_hang mediumint unsigned not null,
    tenmathang varchar(50) not null,
    chungloai varchar(50) not null,
    gia int not null,
    soluong smallint unsigned not null,
    primary key (id_hang)
);

create table laphoadon(
	id_hoadon varchar(10) not null,
    thoigianlap TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    id_nv tinyint auto_increment not null,
    primary key (id_hoadon),
    foreign key (id_nv) references nhanvien(id_nv)
);
CREATE TABLE chitiethoadon (
    id_hoadon VARCHAR(10) NOT NULL,
    id_hang MEDIUMINT UNSIGNED NOT NULL,
    soluong SMALLINT UNSIGNED NOT NULL,
    FOREIGN KEY (id_hoadon)
        REFERENCES laphoadon (id_hoadon),
    FOREIGN KEY (id_hang)
        REFERENCES mathang (id_hang)
);
-- --
INSERT INTO `nhahang`.`login` (`tendangnhap`, `matkhau`, `quenhan`) VALUES ('u1', '1', '1');
INSERT INTO `nhahang`.`login` (`tendangnhap`, `matkhau`, `quenhan`) VALUES ('u2', '1', '1');
INSERT INTO `nhahang`.`login` (`tendangnhap`, `matkhau`, `quenhan`) VALUES ('u3', '1', '2');
INSERT INTO `nhahang`.`login` (`tendangnhap`, `matkhau`, `quenhan`) VALUES ('admin', '1', '3');
-- --
INSERT INTO `nhahang`.`nhanvien` (`id_nv`, `ten_nv`, `gioitinh`, `ngaysinh`, `quequan`, `cmnd`, `sdt`, `hesoluong`, `tendangnhap`, `t2`, `t3`, `t4`, `t5`, `t6`, `t7`, `cn`) VALUES ('1', 'Trang', 'Nữ', '1991-1-11', 'ha Nam', '123456789', '0987654321', '2', 'u1', '1', '1', '0', '0', '0', '0', '1');
INSERT INTO `nhahang`.`nhanvien` (`id_nv`, `ten_nv`, `gioitinh`, `ngaysinh`, `quequan`, `cmnd`, `sdt`, `hesoluong`, `tendangnhap`) VALUES ('2', 'Tâm', 'Nữ', '1991-01-11', 'Hà Nội', '123456777', '0988888888', '1.5', 'u2');

-- --


-- --
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('001', 'Hồ lô chiên', 'Đồ ăn', '12000', '100');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('002', 'Thanh cua viên', 'Đồ ăn', '12000', '100');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('003', 'Thanh cua viên', 'Đồ ăn', '20000', '100');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('004', 'Bánh bao chay', 'Đồ ăn', '6000', '100');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('005', 'Bánh bao thịt', 'Đồ ăn', '12000', '100');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('006', 'Bánh bao xá xíu', 'Đồ ăn', '15000', '50');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('007', 'Nem chua rán', 'Đồ ăn', '4000', '200');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('008', 'Xúc xích rán', 'Đồ ăn', '10000', '200');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('009', 'Lạp xưởng', 'Đồ ăn', '8000', '200');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('010', 'Há cảo', 'Đồ ăn', '10000', '100');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('011', 'Chả cá', 'Đồ ăn', '10000', '50');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('012', 'Bánh tôm', 'Đồ ăn', '6000', '100');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('013', 'Cốm trứng', 'Đồ ăn', '10000', '50');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('014', 'Phô mai que', 'Đồ ăn', '5000', '100');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('015', 'Phô mai que cốm', 'Đồ ăn', '5000', '50');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('017', 'Sữa chua chiên giòn', 'Đồ ăn', '12000', '50');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('018', 'Bánh mì trứng', 'Đồ ăn', '10000', '50');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('019', 'Bánh mì thịt xiên', 'Đồ ăn', '10000', '30');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('020', 'Bánh mì bò khô', 'Đồ ăn', '9000', '30');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('021', 'Bánh mì trứng bate', 'Đồ ăn', '12000', '15');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('022', 'Bánh mì xúc xích', 'Đồ ăn', '15000', '15');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('023', 'Bánh mì trứng lá ngải', 'Đồ ăn', '10000', '15');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('024', 'Bánh mì trứng ruốc', 'Đồ ăn', '12000', '15');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('025', 'Bánh mì nhân ruốc', 'Đồ ăn', '6000', '20');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('026', 'Bánh mì gối', 'Đồ ăn', '10000', '10');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('027', 'Snack tôm', 'Đồ ăn', '5000', '20');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('028', 'Snack oishi', 'Đồ ăn', '5000', '20');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('029', 'Snack swing', 'Đồ ăn', '6000', '20');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('030', 'Snack hành', 'Đồ ăn', '5000', '20');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('031', 'Snack cua', 'Đồ ăn', '6000', '20');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('032', 'Snack ngô', 'Đồ ăn', '5000', '20');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('033', 'Snack khoai tây', 'Đồ ăn', '10000', '20');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('034', 'Snack poca', 'Đồ ăn', '5000', '20');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('035', 'Snackstar', 'Đồ ăn', '5000', '20');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('036', 'Snack indo chip', 'Đồ ăn', '5000', '20');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('037', 'Hạt sen chiên', 'Đồ ăn', '10000', '10');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('038', 'Bim bim que', 'Đồ ăn', '10000', '20');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('039', 'Ngô cay', 'Đồ ăn', '15000', '20');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('040', 'Khoai tây que', 'Đồ ăn', '10000', '10');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('041', 'Hướng hương', 'Đồ ăn', '5000', '20');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('042', 'Đậu phộng', 'Đồ ăn', '10000', '20');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('043', 'Bắp rang bơ', 'Đồ ăn', '5000', '20');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('044', 'Bắp rang cacao', 'Đồ ăn', '5000', '10');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('045', 'Bim bim thái', 'Đồ ăn', '20000', '10');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('046', 'Quẩy tôm', 'Đồ ăn', '15000', '10');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('047', 'Quẩy rong biển', 'Đồ ăn', '15000', '10');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('048', 'Heo khô', 'Đồ ăn', '15000', '10');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('049', 'Ô mai', 'Đồ ăn', '20000', '5');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('050', 'Bánh quy trứng muối', 'Đồ ăn', '10000', '10');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('051', 'Bánh gấu nhân kem', 'Đồ ăn', '15000', '10');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('052', 'Bánh cá mặn', 'Đồ ăn', '10000', '10');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('053', 'Chè thập cẩm', 'Đồ ăn', '15000', '15');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('054', 'Chè ngô', 'Đồ ăn', '10000', '15');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('055', 'Chè khoai', 'Đồ ăn', '10000', '10')	;
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('056', 'Chè thái', 'Đồ ăn', '10000', '10');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('057', 'Chè chân châu', 'Đồ ăn', '10000', '10');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('059', 'Tào phớ', 'Đồ ăn', '5000', '15');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('060', 'Sữa chua đánh đá', 'Đồ ăn', '10000', '10');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('061', 'Nước lọc', 'Đồ uống', '5000', '100');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('062', 'Sting', 'Đồ uống', '8000', '100');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('063', 'Coca', 'Đồ uống', '5000', '100');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('064', 'Pepsi', 'Đồ uống', '5000', '100');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('065', 'Nước cam', 'Đồ uống', '8000', '50');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('066', 'Trà chanh', 'Đồ uống', '5000', '50');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('077', 'Sữa dậu nành', 'Đồ uống', '5000', '20');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('067', 'Sữa milo', 'Đồ uống', '8000', '20');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('068', 'Trà bí đao', 'Đồ uống', '5000', '20');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('069', 'Trà đào', 'Đồ uống', '10000', '10');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('070', 'Nước dừa', 'Đồ uống', '20000', '10');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('071', '7 up', 'Đồ uống', '8000', '10');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('072', 'Chanh leo', 'Đồ uống', '8000', '10');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('073', 'Cafe đen', 'Đồ uống', '20000', '20');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('074', 'Cafe nâu', 'Đồ uống', '15000', '20');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('075', 'Trà ô long', 'Đồ uống', '12000', '20');
INSERT INTO `nhahang`.`mathang` (`id_hang`, `tenmathang`, `chungloai`, `gia`, `soluong`) VALUES ('076', 'Bò húc', 'Đồ uống', '15000', '20');