use quanlydatphong;

-- câu 1: Liệt kê MaDatPhong, MaDV, SoLuong của tất cả các dịch vụ có số lượng lớn hơn 3
-- và nhỏ hơn 10.
select *
from chi_tiet_su_dung_dich_vu
where SoLuong > 3 and SoLuong <10;

-- câu 2Cập nhật dữ liệu trên trường GiaPhong thuộc bảng PHONG tăng lên 10,000 VNĐ
-- so với giá phòng hiện tại, chỉ cập nhật giá phòng của những phòng có số khách tối đa
-- lớn hơn 10.

UPDATE phong
SET phong.GiaPhong = 10000
WHERE phong.SoKhachToiDa > 10;

-- câu 3 Xóa tất cả những đơn đặt phòng (từ bảng DAT_PHONG) có
-- trạng thái đặt (TrangThaiDat) là “Da huy”.
DELETE FROM dat_phong where TrangThaiDat = N'DaHuy';

-- câu 4 Hiển thị TenKH của những khách hàng có tên bắt đầu là một trong các ký tự
-- “H”, “N”, “M” và có độ dài tối đa là 12 ký tự.
SELECT * FROM khach_hang
where (TenKhachHang like 'H%' or TenKhachHang like 'N%' or TenKhachHang like 'M%')
AND length(TenKhachHang) <= 12;

-- câu 5 Hiển thị TenKH của tất cả các khách hàng có trong hệ thống,
-- TenKH nào trùng nhau thì chỉ hiển thị một lần.

SELECT distinct TenKhachHang FROM khach_hang;

-- câu 6 Hiển thị MaDV, TenDV, DonViTinh, DonGia của những dịch vụ đi kèm
-- có DonViTinh là “lon” và có DonGia lớn hơn 10,000 VNĐ hoặc những dịch vụ đi kèm
-- có DonViTinh là “Cai” và có DonGia nhỏ hơn 5,000 VNĐ.

SELECT MaDichVU, TenDichVu, DonViTinh, DonGia
FROM dich_vu_di_kem
WHERE (DonViTinh = 'lon' and DonGia > 10000)
or (DonViTinh = 'cai' and DonGia > 5000);

-- câu 7Hiển thị MaDatPhong, MaPhong, LoaiPhong, SoKhachToiDa, GiaPhong, MaKH,
-- TenKH, SoDT, NgayDat, GioBatDau, GioKetThuc, MaDichVu, SoLuong, DonGia
-- của những đơn đặt phòng có năm đặt phòng là “2016”, “2017” và đặt những phòng 
-- có giá phòng > 50,000 VNĐ/ 1 giờ.

SELECT dp.MaDatPhong, dp.MaPhong, p.LoaiPhong, p.SoKhachToiDa,
p.GiaPhong, kh.MaKhachHang, kh.TenKhachHang, kh.SoDT,
dp.NgayDat, dp.GioBatDau, dp.GioKetThuc, dv.MaDichVu, ct.SoLuong, dv.DonGia
FROM dat_phong dp 
JOIN khach_hang kh 
on dp.MaKhachHang = kh.MaKhachHang 
JOIN phong p 
on dp.MaPhong = p.MaPhong 
JOIN chi_tiet_su_dung_dich_vu ct 
ON dp.MaDatPhong = ct.MaDatPhong
JOIN dich_vu_di_kem dv 
ON ct.MaDichVu = dv.MaDichVu
WHERE (YEAR(dp.NgayDat) = 2016 OR YEAR(dp.NgayDat) = 2017) AND p.GiaPhong > 5000;

-- câu 8 Hiển thị MaDatPhong, MaPhong, LoaiPhong, GiaPhong, TenKH, NgayDat,
-- TongTienHat, TongTienSuDungDichVu, TongTienThanhToan tương ứng
-- với từng mã đặt phòng có trong bảng DAT_PHONG.
-- Những đơn đặt phòng nào không sử dụng dịch vụ đi kèm thì cũng liệt kê thông tin
-- của đơn đặt phòng đó ra.
 

-- câu 9 Hiển thị MaKH, TenKH, DiaChi, SoDT của những khách hàng đã từng đặt phòng karaoke
-- có địa chỉ ở “Hoa xuan”.
SELECT distinct kh.MaKhachHang, kh.TenKhachHang, kh.DiaChi, kh.SoDT
FROM khach_hang kh join dat_phong dp on kh.MaKhachHang = dp.MaKhachHang
WHERE dp.TrangThaiDat = N'DaDat' and kh.DiaChi = N'Hoa Xuan';

-- câu 10 Hiển thị MaPhong, LoaiPhong, SoKhachToiDa, GiaPhong, SoLanDat của
-- những phòng được khách hàng đặt có số lần đặt lớn hơn 1 lần và trạng thái đặt
-- là “Da dat”.

SELECT p.MaPhong,p.LoaiPhong,p.SoKhachToiDa,p.GiaPhong, COUNT(dp.MaPhong) AS SoLuongDat
FROM phong p
JOIN dat_phong dp 
ON p.MaPhong = dp.MaPhong
WHERE dp.TrangThaiDat = 'DaDat'
GROUP BY p.MaPhong
HAVING COUNT(dp.MaPhong) > 2

