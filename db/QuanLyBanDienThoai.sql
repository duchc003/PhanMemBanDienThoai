USE [QuanLyBanDienThoai]
GO
/****** Object:  Table [dbo].[ChiTietSanPham]    Script Date: 11/26/2022 9:02:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietSanPham](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[IDSP] [int] NULL,
	[IDNCC] [int] NULL,
	[SoLuong] [int] NULL,
	[Ram] [nvarchar](50) NULL,
	[XuatXu] [nvarchar](50) NULL,
	[Camera] [nvarchar](50) NULL,
	[ManHinh] [nvarchar](50) NULL,
	[BoNho] [nvarchar](50) NULL,
	[MauSac] [nvarchar](50) NULL,
	[GiaNhap] [float] NULL,
	[GiaBan] [float] NULL,
	[Image] [nvarchar](50) NULL,
	[Barcode] [nvarchar](50) NULL,
	[TrangThai] [nvarchar](100) NULL,
	[MoTa] [nvarchar](50) NULL,
 CONSTRAINT [PK_ChiTietSanPham] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HangSanPham]    Script Date: 11/26/2022 9:02:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HangSanPham](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaHangSP] [nvarchar](50) NULL,
	[TenHangSP] [nvarchar](100) NULL,
 CONSTRAINT [PK_HangSanPham] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HinhThucGiaoHang]    Script Date: 11/26/2022 9:02:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HinhThucGiaoHang](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[TenHTGH] [nvarchar](100) NULL,
 CONSTRAINT [PK_HinhThucGiaoHang] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HinhThucThanhToan]    Script Date: 11/26/2022 9:02:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HinhThucThanhToan](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[TenHTTT] [nvarchar](100) NULL,
 CONSTRAINT [PK_HinhThucThanhToan] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 11/26/2022 9:02:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[IDKhachHang] [int] NULL,
	[IDNhanVien] [int] NULL,
	[IDHinhTTT] [int] NULL,
	[IDHinhTGH] [int] NULL,
	[MaHD] [nvarchar](50) NULL,
	[NgayTao] [date] NULL,
	[NgayThanhToan] [date] NULL,
	[NgayNhanHang] [date] NULL,
	[NgayGiaoHang] [date] NULL,
	[NgayKhachNhanHang] [date] NULL,
	[TienKhachCanTra] [float] NULL,
	[TongTien] [float] NULL,
	[SdtNguoiNhan] [nvarchar](50) NULL,
	[PhanTramGiamGia] [nvarchar](50) NULL,
	[TrangThai] [int] NULL,
	[Mota] [nvarchar](100) NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDonChiTiet]    Script Date: 11/26/2022 9:02:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonChiTiet](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[IDSP] [int] NULL,
	[IDHoaDon] [int] NULL,
	[SoLuong] [int] NULL,
	[TienThua] [float] NULL,
	[DonGia] [float] NULL,
	[TienGiamGia] [float] NULL,
 CONSTRAINT [PK_HoaDonChiTiet] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 11/26/2022 9:02:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaKH] [nvarchar](50) NULL,
	[HoVaTen] [nvarchar](100) NULL,
	[SoDienThoai] [nvarchar](50) NULL,
	[NgaySinh] [date] NULL,
	[DiaChi] [nvarchar](100) NULL,
	[GioiTinh] [nvarchar](50) NULL,
	[MoTa] [nvarchar](100) NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhuyenMai]    Script Date: 11/26/2022 9:02:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhuyenMai](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaKM] [nvarchar](50) NULL,
	[Ten] [nvarchar](100) NULL,
	[NgayBD] [date] NULL,
	[NgayKT] [date] NULL,
	[GiamGia] [float] NULL,
	[HinhThuc] [nvarchar](50) NULL,
	[TrangThai] [nvarchar](50) NULL,
	[Mota] [nvarchar](100) NULL,
 CONSTRAINT [PK_KhuyenMai] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 11/26/2022 9:02:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaCungCap](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaNCC] [nvarchar](50) NULL,
	[TenNCC] [nvarchar](100) NULL,
 CONSTRAINT [PK_NhaCungCap] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 11/26/2022 9:02:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaNV] [nvarchar](50) NULL,
	[HoVaTen] [nvarchar](100) NULL,
	[DiaChi] [nvarchar](100) NULL,
	[GioiTinh] [nvarchar](50) NULL,
	[SDT] [nvarchar](50) NULL,
	[Email] [nvarchar](200) NULL,
	[TaiKhoan] [nvarchar](50) NULL,
	[MatKhau] [nvarchar](50) NULL,
	[VaiTro] [bit] NULL,
	[TrangThai] [nvarchar](50) NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhuKien]    Script Date: 11/26/2022 9:02:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhuKien](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaPhuKien] [nvarchar](50) NULL,
	[TenPhuKien] [nvarchar](100) NULL,
 CONSTRAINT [PK_PhuKien] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 11/26/2022 9:02:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[IDKM] [int] NULL,
	[IDPK] [int] NULL,
	[IDHang] [int] NULL,
	[MaSP] [nvarchar](50) NULL,
	[TenSp] [nvarchar](100) NULL,
 CONSTRAINT [PK_SanPham] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[ChiTietSanPham] ON 

INSERT [dbo].[ChiTietSanPham] ([ID], [IDSP], [IDNCC], [SoLuong], [Ram], [XuatXu], [Camera], [ManHinh], [BoNho], [MauSac], [GiaNhap], [GiaBan], [Image], [Barcode], [TrangThai], [MoTa]) VALUES (1, 1, 1, 123, N'2G', N'Mỹ', N'1 Mắt', N'2 inch', N'16GB', N'Đen', 5000000, 6000000, NULL, NULL, N'Còn Hàng', N'Iphone')
INSERT [dbo].[ChiTietSanPham] ([ID], [IDSP], [IDNCC], [SoLuong], [Ram], [XuatXu], [Camera], [ManHinh], [BoNho], [MauSac], [GiaNhap], [GiaBan], [Image], [Barcode], [TrangThai], [MoTa]) VALUES (2, 2, 1, 11, N'2G', N'Nhật Bản', N'1 Mắt', N'2 inch', N'16GB', N'Đen', 5000000, 6000000, NULL, NULL, N'Còn Hàng', N'Iphone')
INSERT [dbo].[ChiTietSanPham] ([ID], [IDSP], [IDNCC], [SoLuong], [Ram], [XuatXu], [Camera], [ManHinh], [BoNho], [MauSac], [GiaNhap], [GiaBan], [Image], [Barcode], [TrangThai], [MoTa]) VALUES (3, 3, 1, 43, N'2G', N'Mỹ', N'1 Mắt', N'3 inch', N'16GB', N'Trắng', 5000000, 6000000, NULL, NULL, N'Còn Hàng', N'Iphone')
INSERT [dbo].[ChiTietSanPham] ([ID], [IDSP], [IDNCC], [SoLuong], [Ram], [XuatXu], [Camera], [ManHinh], [BoNho], [MauSac], [GiaNhap], [GiaBan], [Image], [Barcode], [TrangThai], [MoTa]) VALUES (4, 4, 1, 23, N'4G', N'Việt Nam', N'1 Mắt', N'3 inch', N'32GB', N'Đen', 5000000, 6000000, NULL, NULL, N'Còn Hàng', N'Iphone')
INSERT [dbo].[ChiTietSanPham] ([ID], [IDSP], [IDNCC], [SoLuong], [Ram], [XuatXu], [Camera], [ManHinh], [BoNho], [MauSac], [GiaNhap], [GiaBan], [Image], [Barcode], [TrangThai], [MoTa]) VALUES (5, 5, 1, 54, N'4G', N'Singapore', N'2 Mắt', N'3 inch
', N'32GB', N'Trắng', 6000000, 7000000, NULL, NULL, N'Còn Hàng', N'Iphone')
INSERT [dbo].[ChiTietSanPham] ([ID], [IDSP], [IDNCC], [SoLuong], [Ram], [XuatXu], [Camera], [ManHinh], [BoNho], [MauSac], [GiaNhap], [GiaBan], [Image], [Barcode], [TrangThai], [MoTa]) VALUES (6, 6, 1, 23, N'4G', N'Mỹ', N'2 Mắt', N'3 inch
', N'32GB', N'Đen', 7000000, 7000000, NULL, NULL, N'Còn Hàng', N'Iphone')
INSERT [dbo].[ChiTietSanPham] ([ID], [IDSP], [IDNCC], [SoLuong], [Ram], [XuatXu], [Camera], [ManHinh], [BoNho], [MauSac], [GiaNhap], [GiaBan], [Image], [Barcode], [TrangThai], [MoTa]) VALUES (7, 7, 1, 0, N'4G', N'Singapore', N'2 Mắt', N'3 inch
', N'32GB', N'Trắng', 5000000, 7000000, NULL, NULL, N'Hết Hàng', N'Iphone')
INSERT [dbo].[ChiTietSanPham] ([ID], [IDSP], [IDNCC], [SoLuong], [Ram], [XuatXu], [Camera], [ManHinh], [BoNho], [MauSac], [GiaNhap], [GiaBan], [Image], [Barcode], [TrangThai], [MoTa]) VALUES (8, 8, 1, 12, N'4G', N'Việt Nam', N'2 Mắt', N'3 inch
', N'32GB', N'Đen', 5000000, 7000000, NULL, NULL, N'Còn Hàng', N'Iphone')
INSERT [dbo].[ChiTietSanPham] ([ID], [IDSP], [IDNCC], [SoLuong], [Ram], [XuatXu], [Camera], [ManHinh], [BoNho], [MauSac], [GiaNhap], [GiaBan], [Image], [Barcode], [TrangThai], [MoTa]) VALUES (9, 9, 1, 0, N'4G', N'Mỹ', N'2 Mắt', N'3 inch
', N'32GB', N'Đỏ', 5000000, 7000000, NULL, NULL, N'Hết Hàng', N'Iphone')
INSERT [dbo].[ChiTietSanPham] ([ID], [IDSP], [IDNCC], [SoLuong], [Ram], [XuatXu], [Camera], [ManHinh], [BoNho], [MauSac], [GiaNhap], [GiaBan], [Image], [Barcode], [TrangThai], [MoTa]) VALUES (10, 10, 1, 23, N'8G', N'Trung Quốc', N'2 Mắt', N'3 inch
', N'32GB', N'Trắng', 9000000, 1200000, NULL, NULL, N'Còn Hàng', N'Iphone')
INSERT [dbo].[ChiTietSanPham] ([ID], [IDSP], [IDNCC], [SoLuong], [Ram], [XuatXu], [Camera], [ManHinh], [BoNho], [MauSac], [GiaNhap], [GiaBan], [Image], [Barcode], [TrangThai], [MoTa]) VALUES (11, 11, 1, 0, N'8G', N'Singapore', N'2 Mắt', N'4 inch
', N'64GB', N'Trắng', 9000000, 1600000, NULL, NULL, N'Hết Hàng', N'Iphone')
INSERT [dbo].[ChiTietSanPham] ([ID], [IDSP], [IDNCC], [SoLuong], [Ram], [XuatXu], [Camera], [ManHinh], [BoNho], [MauSac], [GiaNhap], [GiaBan], [Image], [Barcode], [TrangThai], [MoTa]) VALUES (12, 12, 1, 233, N'8G', N'Mỹ', N'3 Mắt', N'8 inch
', N'125GB', N'Xanh', 1100000, 1900000, NULL, NULL, N'Còn Hàng', N'Iphone')
INSERT [dbo].[ChiTietSanPham] ([ID], [IDSP], [IDNCC], [SoLuong], [Ram], [XuatXu], [Camera], [ManHinh], [BoNho], [MauSac], [GiaNhap], [GiaBan], [Image], [Barcode], [TrangThai], [MoTa]) VALUES (13, 13, 1, 0, N'8G', N'Nhật Bản', N'3 Mắt', N'8 inch
', N'125GB', N'Xanh', 1100000, 1900000, NULL, NULL, N'Hết Hàng', N'Iphone')
INSERT [dbo].[ChiTietSanPham] ([ID], [IDSP], [IDNCC], [SoLuong], [Ram], [XuatXu], [Camera], [ManHinh], [BoNho], [MauSac], [GiaNhap], [GiaBan], [Image], [Barcode], [TrangThai], [MoTa]) VALUES (14, 14, 1, 222, N'8G', N'Việt Nam', N'3 Mắt', N'8 inch
', N'125GB', N'Đen', 1100000, 1900000, NULL, NULL, N'Còn Hàng', N'Iphone')
INSERT [dbo].[ChiTietSanPham] ([ID], [IDSP], [IDNCC], [SoLuong], [Ram], [XuatXu], [Camera], [ManHinh], [BoNho], [MauSac], [GiaNhap], [GiaBan], [Image], [Barcode], [TrangThai], [MoTa]) VALUES (15, 15, 1, 0, N'8G', N'Nhật Bản', N'3 Mắt', N'8 inch
', N'125GB', N'Tím', 1100000, 1900000, NULL, NULL, N'Hết Hàng', N'Iphone')
INSERT [dbo].[ChiTietSanPham] ([ID], [IDSP], [IDNCC], [SoLuong], [Ram], [XuatXu], [Camera], [ManHinh], [BoNho], [MauSac], [GiaNhap], [GiaBan], [Image], [Barcode], [TrangThai], [MoTa]) VALUES (16, 16, 2, 222, N'8G', N'Singapore', N'3 Mắt', N'8 inch
', N'250GB', N'Trắng', 2200000, 2500000, NULL, NULL, N'Còn Hàng', N'SamSung')
INSERT [dbo].[ChiTietSanPham] ([ID], [IDSP], [IDNCC], [SoLuong], [Ram], [XuatXu], [Camera], [ManHinh], [BoNho], [MauSac], [GiaNhap], [GiaBan], [Image], [Barcode], [TrangThai], [MoTa]) VALUES (17, 17, 2, 12, N'8G', N'Trung Quốc', N'4 Mắt', N'8 inch
', N'64GB', N'Đen', 2200000, 2300000, NULL, NULL, N'Còn Hàng', N'SamSung')
INSERT [dbo].[ChiTietSanPham] ([ID], [IDSP], [IDNCC], [SoLuong], [Ram], [XuatXu], [Camera], [ManHinh], [BoNho], [MauSac], [GiaNhap], [GiaBan], [Image], [Barcode], [TrangThai], [MoTa]) VALUES (18, 18, 2, 12, N'8G', N'Việt Nam', N'3 Mắt', N'8 inch
', N'250GB', N'Đen', 2200000, 2500000, NULL, NULL, N'Còn Hàng', N'SamSung')
INSERT [dbo].[ChiTietSanPham] ([ID], [IDSP], [IDNCC], [SoLuong], [Ram], [XuatXu], [Camera], [ManHinh], [BoNho], [MauSac], [GiaNhap], [GiaBan], [Image], [Barcode], [TrangThai], [MoTa]) VALUES (19, 19, 3, 33, N'8G', N'Mỹ', N'4 Mắt', N'8 inch
', N'64GB', N'Đen', 9000000, 1200000, NULL, NULL, N'Còn Hàng', N'Oppo')
INSERT [dbo].[ChiTietSanPham] ([ID], [IDSP], [IDNCC], [SoLuong], [Ram], [XuatXu], [Camera], [ManHinh], [BoNho], [MauSac], [GiaNhap], [GiaBan], [Image], [Barcode], [TrangThai], [MoTa]) VALUES (20, 20, 3, 21, N'8G', N'Singapore', N'4 Mắt', N'4 inch', N'32GB', N'Trắng', 7000000, 9000000, NULL, NULL, N'Còn Hàng', N'Oppo')
INSERT [dbo].[ChiTietSanPham] ([ID], [IDSP], [IDNCC], [SoLuong], [Ram], [XuatXu], [Camera], [ManHinh], [BoNho], [MauSac], [GiaNhap], [GiaBan], [Image], [Barcode], [TrangThai], [MoTa]) VALUES (21, 21, 3, 86, N'4G', N'Việt Nam', N'3 Mắt', N'4 inch', N'64GB', N'Đen', 7000000, 7000000, NULL, NULL, N'Còn Hàng', N'Oppo')
INSERT [dbo].[ChiTietSanPham] ([ID], [IDSP], [IDNCC], [SoLuong], [Ram], [XuatXu], [Camera], [ManHinh], [BoNho], [MauSac], [GiaNhap], [GiaBan], [Image], [Barcode], [TrangThai], [MoTa]) VALUES (22, 22, 3, 0, N'4G', N'Việt Nam', N'2 Mắt', N'4 inch', N'32GB', N'Trắng', 5000000, 7000000, NULL, NULL, N'Hết Hàng', N'Oppo')
SET IDENTITY_INSERT [dbo].[ChiTietSanPham] OFF
GO
SET IDENTITY_INSERT [dbo].[HangSanPham] ON 

INSERT [dbo].[HangSanPham] ([ID], [MaHangSP], [TenHangSP]) VALUES (1, N'HSP01', N'APPLE')
INSERT [dbo].[HangSanPham] ([ID], [MaHangSP], [TenHangSP]) VALUES (2, N'HSP02', N'SAMSUNG')
INSERT [dbo].[HangSanPham] ([ID], [MaHangSP], [TenHangSP]) VALUES (3, N'HSP03', N'OPPO')
SET IDENTITY_INSERT [dbo].[HangSanPham] OFF
GO
SET IDENTITY_INSERT [dbo].[HinhThucGiaoHang] ON 

INSERT [dbo].[HinhThucGiaoHang] ([ID], [TenHTGH]) VALUES (1, N'Tại Quầy')
INSERT [dbo].[HinhThucGiaoHang] ([ID], [TenHTGH]) VALUES (2, N'Khác')
SET IDENTITY_INSERT [dbo].[HinhThucGiaoHang] OFF
GO
SET IDENTITY_INSERT [dbo].[HinhThucThanhToan] ON 

INSERT [dbo].[HinhThucThanhToan] ([ID], [TenHTTT]) VALUES (1, N'Tiền Mặt')
INSERT [dbo].[HinhThucThanhToan] ([ID], [TenHTTT]) VALUES (2, N'Quẹt Thẻ')
INSERT [dbo].[HinhThucThanhToan] ([ID], [TenHTTT]) VALUES (3, N'Quét Mã')
INSERT [dbo].[HinhThucThanhToan] ([ID], [TenHTTT]) VALUES (4, N'Chuyển Khoản')
SET IDENTITY_INSERT [dbo].[HinhThucThanhToan] OFF
GO
SET IDENTITY_INSERT [dbo].[HoaDon] ON 

INSERT [dbo].[HoaDon] ([ID], [IDKhachHang], [IDNhanVien], [IDHinhTTT], [IDHinhTGH], [MaHD], [NgayTao], [NgayThanhToan], [NgayNhanHang], [NgayGiaoHang], [NgayKhachNhanHang], [TienKhachCanTra], [TongTien], [SdtNguoiNhan], [PhanTramGiamGia], [TrangThai], [Mota]) VALUES (1, 1, 1, 1, 1, N'HD01', CAST(N'2022-11-26' AS Date), CAST(N'2022-11-26' AS Date), NULL, NULL, NULL, 6000000, 6000000, N'0971066455', NULL, 1, NULL)
INSERT [dbo].[HoaDon] ([ID], [IDKhachHang], [IDNhanVien], [IDHinhTTT], [IDHinhTGH], [MaHD], [NgayTao], [NgayThanhToan], [NgayNhanHang], [NgayGiaoHang], [NgayKhachNhanHang], [TienKhachCanTra], [TongTien], [SdtNguoiNhan], [PhanTramGiamGia], [TrangThai], [Mota]) VALUES (2, 2, 1, 1, 1, N'HD02', CAST(N'2022-11-26' AS Date), CAST(N'2022-11-26' AS Date), NULL, NULL, NULL, 7000000, 7000000, N'0912437432', NULL, 1, NULL)
INSERT [dbo].[HoaDon] ([ID], [IDKhachHang], [IDNhanVien], [IDHinhTTT], [IDHinhTGH], [MaHD], [NgayTao], [NgayThanhToan], [NgayNhanHang], [NgayGiaoHang], [NgayKhachNhanHang], [TienKhachCanTra], [TongTien], [SdtNguoiNhan], [PhanTramGiamGia], [TrangThai], [Mota]) VALUES (3, 2, 3, 1, 1, N'HD03', CAST(N'2022-11-26' AS Date), CAST(N'2022-11-26' AS Date), NULL, NULL, NULL, 7000000, 7000000, N'0912437432', NULL, 1, NULL)
INSERT [dbo].[HoaDon] ([ID], [IDKhachHang], [IDNhanVien], [IDHinhTTT], [IDHinhTGH], [MaHD], [NgayTao], [NgayThanhToan], [NgayNhanHang], [NgayGiaoHang], [NgayKhachNhanHang], [TienKhachCanTra], [TongTien], [SdtNguoiNhan], [PhanTramGiamGia], [TrangThai], [Mota]) VALUES (4, 3, 2, 1, 1, N'HD04', CAST(N'2022-11-26' AS Date), CAST(N'2022-11-26' AS Date), NULL, NULL, NULL, 7000000, 7000000, N'0238923442', NULL, 1, NULL)
INSERT [dbo].[HoaDon] ([ID], [IDKhachHang], [IDNhanVien], [IDHinhTTT], [IDHinhTGH], [MaHD], [NgayTao], [NgayThanhToan], [NgayNhanHang], [NgayGiaoHang], [NgayKhachNhanHang], [TienKhachCanTra], [TongTien], [SdtNguoiNhan], [PhanTramGiamGia], [TrangThai], [Mota]) VALUES (5, 4, 1, 1, 2, N'HD05', CAST(N'2022-11-26' AS Date), NULL, CAST(N'2022-11-29' AS Date), CAST(N'2022-11-27' AS Date), CAST(N'2022-11-29' AS Date), 25000000, 26000000, N'0232384983', NULL, 3, NULL)
INSERT [dbo].[HoaDon] ([ID], [IDKhachHang], [IDNhanVien], [IDHinhTTT], [IDHinhTGH], [MaHD], [NgayTao], [NgayThanhToan], [NgayNhanHang], [NgayGiaoHang], [NgayKhachNhanHang], [TienKhachCanTra], [TongTien], [SdtNguoiNhan], [PhanTramGiamGia], [TrangThai], [Mota]) VALUES (6, 1, 2, 1, 2, N'HD06', CAST(N'2022-11-26' AS Date), NULL, CAST(N'2022-11-29' AS Date), CAST(N'2022-11-27' AS Date), CAST(N'2022-11-29' AS Date), 19000000, 19000000, N'0971066455', NULL, 3, NULL)
INSERT [dbo].[HoaDon] ([ID], [IDKhachHang], [IDNhanVien], [IDHinhTTT], [IDHinhTGH], [MaHD], [NgayTao], [NgayThanhToan], [NgayNhanHang], [NgayGiaoHang], [NgayKhachNhanHang], [TienKhachCanTra], [TongTien], [SdtNguoiNhan], [PhanTramGiamGia], [TrangThai], [Mota]) VALUES (7, 5, 5, 1, 2, N'HD07', CAST(N'2022-11-26' AS Date), NULL, NULL, CAST(N'2022-11-27' AS Date), CAST(N'2022-11-29' AS Date), 19000000, 19000000, N'0923483433', NULL, 4, NULL)
INSERT [dbo].[HoaDon] ([ID], [IDKhachHang], [IDNhanVien], [IDHinhTTT], [IDHinhTGH], [MaHD], [NgayTao], [NgayThanhToan], [NgayNhanHang], [NgayGiaoHang], [NgayKhachNhanHang], [TienKhachCanTra], [TongTien], [SdtNguoiNhan], [PhanTramGiamGia], [TrangThai], [Mota]) VALUES (8, 3, 3, 1, 2, N'HD08', CAST(N'2022-11-26' AS Date), NULL, NULL, CAST(N'2022-11-27' AS Date), CAST(N'2022-11-29' AS Date), 7000000, 7000000, N'0238923442', NULL, 4, NULL)
INSERT [dbo].[HoaDon] ([ID], [IDKhachHang], [IDNhanVien], [IDHinhTTT], [IDHinhTGH], [MaHD], [NgayTao], [NgayThanhToan], [NgayNhanHang], [NgayGiaoHang], [NgayKhachNhanHang], [TienKhachCanTra], [TongTien], [SdtNguoiNhan], [PhanTramGiamGia], [TrangThai], [Mota]) VALUES (9, 3, 2, 1, 1, N'HD09', CAST(N'2022-11-26' AS Date), NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL)
INSERT [dbo].[HoaDon] ([ID], [IDKhachHang], [IDNhanVien], [IDHinhTTT], [IDHinhTGH], [MaHD], [NgayTao], [NgayThanhToan], [NgayNhanHang], [NgayGiaoHang], [NgayKhachNhanHang], [TienKhachCanTra], [TongTien], [SdtNguoiNhan], [PhanTramGiamGia], [TrangThai], [Mota]) VALUES (10, 3, 2, 1, 1, N'HD10', CAST(N'2022-11-26' AS Date), NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL)
SET IDENTITY_INSERT [dbo].[HoaDon] OFF
GO
SET IDENTITY_INSERT [dbo].[HoaDonChiTiet] ON 

INSERT [dbo].[HoaDonChiTiet] ([ID], [IDSP], [IDHoaDon], [SoLuong], [TienThua], [DonGia], [TienGiamGia]) VALUES (1, 1, 1, 1, 230000, 6000000, NULL)
INSERT [dbo].[HoaDonChiTiet] ([ID], [IDSP], [IDHoaDon], [SoLuong], [TienThua], [DonGia], [TienGiamGia]) VALUES (2, 5, 2, 1, 240000, 7000000, NULL)
INSERT [dbo].[HoaDonChiTiet] ([ID], [IDSP], [IDHoaDon], [SoLuong], [TienThua], [DonGia], [TienGiamGia]) VALUES (3, 6, 3, 1, 230000, 7000000, NULL)
INSERT [dbo].[HoaDonChiTiet] ([ID], [IDSP], [IDHoaDon], [SoLuong], [TienThua], [DonGia], [TienGiamGia]) VALUES (4, 7, 4, 1, 230000, 7000000, NULL)
INSERT [dbo].[HoaDonChiTiet] ([ID], [IDSP], [IDHoaDon], [SoLuong], [TienThua], [DonGia], [TienGiamGia]) VALUES (5, 16, 5, 1, 230000, 26000000, NULL)
INSERT [dbo].[HoaDonChiTiet] ([ID], [IDSP], [IDHoaDon], [SoLuong], [TienThua], [DonGia], [TienGiamGia]) VALUES (6, 14, 6, 1, 230000, 19000000, NULL)
INSERT [dbo].[HoaDonChiTiet] ([ID], [IDSP], [IDHoaDon], [SoLuong], [TienThua], [DonGia], [TienGiamGia]) VALUES (7, 15, 7, 1, 230000, 19000000, NULL)
INSERT [dbo].[HoaDonChiTiet] ([ID], [IDSP], [IDHoaDon], [SoLuong], [TienThua], [DonGia], [TienGiamGia]) VALUES (8, 9, 8, 1, 230000, 7000000, NULL)
SET IDENTITY_INSERT [dbo].[HoaDonChiTiet] OFF
GO
SET IDENTITY_INSERT [dbo].[KhachHang] ON 

INSERT [dbo].[KhachHang] ([ID], [MaKH], [HoVaTen], [SoDienThoai], [NgaySinh], [DiaChi], [GioiTinh], [MoTa]) VALUES (1, N'KH01', N'Hoàng Công Đức', N'0971066455', CAST(N'2003-08-28' AS Date), N'Phú Thọ', N'Nam', N'Khách Hàng')
INSERT [dbo].[KhachHang] ([ID], [MaKH], [HoVaTen], [SoDienThoai], [NgaySinh], [DiaChi], [GioiTinh], [MoTa]) VALUES (2, N'KH02', N'Nguyễn Mạnh Hiếu', N'0912437432', CAST(N'2003-12-22' AS Date), N'Lào Cai', N'Nam', N'Khách Hàng')
INSERT [dbo].[KhachHang] ([ID], [MaKH], [HoVaTen], [SoDienThoai], [NgaySinh], [DiaChi], [GioiTinh], [MoTa]) VALUES (3, N'KH03', N'Hoàng Minh Huy', N'0238923442', CAST(N'2003-11-12' AS Date), N'Hà Nội', N'Nam', N'Khách Hàng')
INSERT [dbo].[KhachHang] ([ID], [MaKH], [HoVaTen], [SoDienThoai], [NgaySinh], [DiaChi], [GioiTinh], [MoTa]) VALUES (4, N'KH04', N'Bùi Quang Huy', N'0232384983', CAST(N'2003-09-12' AS Date), N'Hà Nội', N'Nam', N'Khách Hàng')
INSERT [dbo].[KhachHang] ([ID], [MaKH], [HoVaTen], [SoDienThoai], [NgaySinh], [DiaChi], [GioiTinh], [MoTa]) VALUES (5, N'KH05', N'Nguyễn Đức Nam', N'0923483433', CAST(N'2003-09-22' AS Date), N'Hà Nội', N'Nam', N'Khách Hàng')
SET IDENTITY_INSERT [dbo].[KhachHang] OFF
GO
SET IDENTITY_INSERT [dbo].[KhuyenMai] ON 

INSERT [dbo].[KhuyenMai] ([ID], [MaKM], [Ten], [NgayBD], [NgayKT], [GiamGia], [HinhThuc], [TrangThai], [Mota]) VALUES (1, N'KM01', N'Chương Trình Khuyến Mãi', CAST(N'2022-11-26' AS Date), CAST(N'2022-11-29' AS Date), 20, N'Giảm Giá Sản Phẩm', N'Hoạt Động', N'Điều khoản & Điều kiện trong chương trình khuyến mãi Sản Phẩm')
INSERT [dbo].[KhuyenMai] ([ID], [MaKM], [Ten], [NgayBD], [NgayKT], [GiamGia], [HinhThuc], [TrangThai], [Mota]) VALUES (2, N'KM02', N'Chương Trình Khuyến Mãi', CAST(N'2022-11-29' AS Date), CAST(N'2022-12-02' AS Date), 25, N'Giảm Giá Sản Phẩm', N'Hoạt Động', N'Điều khoản & Điều kiện trong chương trình khuyến mãi Sản Phẩm')
SET IDENTITY_INSERT [dbo].[KhuyenMai] OFF
GO
SET IDENTITY_INSERT [dbo].[NhaCungCap] ON 

INSERT [dbo].[NhaCungCap] ([ID], [MaNCC], [TenNCC]) VALUES (1, N'NCC01', N'APPLE')
INSERT [dbo].[NhaCungCap] ([ID], [MaNCC], [TenNCC]) VALUES (2, N'NCC02', N'SAMSUNG')
INSERT [dbo].[NhaCungCap] ([ID], [MaNCC], [TenNCC]) VALUES (3, N'NCC03', N'OPPO')
SET IDENTITY_INSERT [dbo].[NhaCungCap] OFF
GO
SET IDENTITY_INSERT [dbo].[NhanVien] ON 

INSERT [dbo].[NhanVien] ([ID], [MaNV], [HoVaTen], [DiaChi], [GioiTinh], [SDT], [Email], [TaiKhoan], [MatKhau], [VaiTro], [TrangThai]) VALUES (1, N'NV01', N'Hoàng Công Đức', N'Phú Thọ', N'Nam', N'0971066455', N'duchcph22577@fpt.edu.vn', N'duchcph22577', N'123', 1, N'Hoạt Động')
INSERT [dbo].[NhanVien] ([ID], [MaNV], [HoVaTen], [DiaChi], [GioiTinh], [SDT], [Email], [TaiKhoan], [MatKhau], [VaiTro], [TrangThai]) VALUES (2, N'NV02', N'Bùi Quang Huy', N'Hà Nội', N'Nam', N'0238423432', N'huybqph22581@fpt.edu.vn', N'huybqph22581', N'123', 1, N'Hoạt Động')
INSERT [dbo].[NhanVien] ([ID], [MaNV], [HoVaTen], [DiaChi], [GioiTinh], [SDT], [Email], [TaiKhoan], [MatKhau], [VaiTro], [TrangThai]) VALUES (3, N'NV03', N'Nam Nguyễn Đức', N'Hà Nội', N'Nam', N'0934837423', N'namndph22694@fpt.edu.vn', N'namndph22694', N'123', 1, N'Hoạt Động')
INSERT [dbo].[NhanVien] ([ID], [MaNV], [HoVaTen], [DiaChi], [GioiTinh], [SDT], [Email], [TaiKhoan], [MatKhau], [VaiTro], [TrangThai]) VALUES (4, N'NV04', N'Nguyễn Mạnh Hiếu', N'Lào Cai', N'Nam', N'0293443784', N'hieunmph22569@fpt.edu.vn', N'hieunmph22569', N'123', 1, N'Hoạt Động')
INSERT [dbo].[NhanVien] ([ID], [MaNV], [HoVaTen], [DiaChi], [GioiTinh], [SDT], [Email], [TaiKhoan], [MatKhau], [VaiTro], [TrangThai]) VALUES (5, N'NV05', N'Hoàng Minh Huy', N'Hà Nội', N'Nam', N'0923824722', N'huyhmph22668@fpt.edu.vn', N'huyhmph22668', N'123', 1, N'Hoạt Động')
SET IDENTITY_INSERT [dbo].[NhanVien] OFF
GO
SET IDENTITY_INSERT [dbo].[PhuKien] ON 

INSERT [dbo].[PhuKien] ([ID], [MaPhuKien], [TenPhuKien]) VALUES (1, N'PK01', N'Tai Nghe')
INSERT [dbo].[PhuKien] ([ID], [MaPhuKien], [TenPhuKien]) VALUES (2, N'PK02', N'Sạc Dự Phòng')
SET IDENTITY_INSERT [dbo].[PhuKien] OFF
GO
SET IDENTITY_INSERT [dbo].[SanPham] ON 

INSERT [dbo].[SanPham] ([ID], [IDKM], [IDPK], [IDHang], [MaSP], [TenSp]) VALUES (1, 1, 1, 1, N'SP01', N'Iphone 5')
INSERT [dbo].[SanPham] ([ID], [IDKM], [IDPK], [IDHang], [MaSP], [TenSp]) VALUES (2, 1, 1, 1, N'SP02', N'Iphone 5s')
INSERT [dbo].[SanPham] ([ID], [IDKM], [IDPK], [IDHang], [MaSP], [TenSp]) VALUES (3, 1, 1, 1, N'SP03', N'Iphone 6')
INSERT [dbo].[SanPham] ([ID], [IDKM], [IDPK], [IDHang], [MaSP], [TenSp]) VALUES (4, 2, 2, 1, N'SP04', N'Iphone 6s')
INSERT [dbo].[SanPham] ([ID], [IDKM], [IDPK], [IDHang], [MaSP], [TenSp]) VALUES (5, 2, 1, 1, N'SP05', N'Iphone 7')
INSERT [dbo].[SanPham] ([ID], [IDKM], [IDPK], [IDHang], [MaSP], [TenSp]) VALUES (6, 2, 2, 1, N'SP06', N'Iphone 7s')
INSERT [dbo].[SanPham] ([ID], [IDKM], [IDPK], [IDHang], [MaSP], [TenSp]) VALUES (7, 1, 1, 1, N'SP07', N'Iphone 7 plus')
INSERT [dbo].[SanPham] ([ID], [IDKM], [IDPK], [IDHang], [MaSP], [TenSp]) VALUES (8, 1, 2, 1, N'SP08', N'Iphone 8')
INSERT [dbo].[SanPham] ([ID], [IDKM], [IDPK], [IDHang], [MaSP], [TenSp]) VALUES (9, 1, 1, 1, N'SP09', N'Iphone 8s')
INSERT [dbo].[SanPham] ([ID], [IDKM], [IDPK], [IDHang], [MaSP], [TenSp]) VALUES (10, 2, 2, 1, N'SP10', N'Iphone X')
INSERT [dbo].[SanPham] ([ID], [IDKM], [IDPK], [IDHang], [MaSP], [TenSp]) VALUES (11, 2, 2, 1, N'SP11', N'Iphone Xs')
INSERT [dbo].[SanPham] ([ID], [IDKM], [IDPK], [IDHang], [MaSP], [TenSp]) VALUES (12, 1, 1, 1, N'SP12', N'Iphone Xs Max')
INSERT [dbo].[SanPham] ([ID], [IDKM], [IDPK], [IDHang], [MaSP], [TenSp]) VALUES (13, 1, 1, 1, N'SP13', N'Iphone 12')
INSERT [dbo].[SanPham] ([ID], [IDKM], [IDPK], [IDHang], [MaSP], [TenSp]) VALUES (14, 2, 1, 1, N'SP14', N'Iphone 12 Pro')
INSERT [dbo].[SanPham] ([ID], [IDKM], [IDPK], [IDHang], [MaSP], [TenSp]) VALUES (15, 1, 2, 1, N'SP15', N'Iphone 13')
INSERT [dbo].[SanPham] ([ID], [IDKM], [IDPK], [IDHang], [MaSP], [TenSp]) VALUES (16, 1, 1, 2, N'SP16', N'Samsung Galaxy S20 FE')
INSERT [dbo].[SanPham] ([ID], [IDKM], [IDPK], [IDHang], [MaSP], [TenSp]) VALUES (17, 1, 2, 2, N'SP17', N'Samsung Galaxy A73')
INSERT [dbo].[SanPham] ([ID], [IDKM], [IDPK], [IDHang], [MaSP], [TenSp]) VALUES (18, 1, 1, 2, N'SP18', N'Samsung Galaxy S22 Ultra')
INSERT [dbo].[SanPham] ([ID], [IDKM], [IDPK], [IDHang], [MaSP], [TenSp]) VALUES (19, 2, 2, 3, N'SP19', N'OPPO Reno6 Z')
INSERT [dbo].[SanPham] ([ID], [IDKM], [IDPK], [IDHang], [MaSP], [TenSp]) VALUES (20, 1, 1, 3, N'SP20', N'OPPO Reno6')
INSERT [dbo].[SanPham] ([ID], [IDKM], [IDPK], [IDHang], [MaSP], [TenSp]) VALUES (21, 2, 2, 3, N'SP21', N'OPPO A94')
INSERT [dbo].[SanPham] ([ID], [IDKM], [IDPK], [IDHang], [MaSP], [TenSp]) VALUES (22, 2, 1, 3, N'SP22', N'OPPO')
SET IDENTITY_INSERT [dbo].[SanPham] OFF
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietSanPham_NhaCungCap] FOREIGN KEY([IDNCC])
REFERENCES [dbo].[NhaCungCap] ([ID])
GO
ALTER TABLE [dbo].[ChiTietSanPham] CHECK CONSTRAINT [FK_ChiTietSanPham_NhaCungCap]
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietSanPham_SanPham] FOREIGN KEY([IDSP])
REFERENCES [dbo].[SanPham] ([ID])
GO
ALTER TABLE [dbo].[ChiTietSanPham] CHECK CONSTRAINT [FK_ChiTietSanPham_SanPham]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_HinhThucGiaoHang] FOREIGN KEY([IDHinhTGH])
REFERENCES [dbo].[HinhThucGiaoHang] ([ID])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_HinhThucGiaoHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_HinhThucThanhToan] FOREIGN KEY([IDHinhTTT])
REFERENCES [dbo].[HinhThucThanhToan] ([ID])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_HinhThucThanhToan]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([IDKhachHang])
REFERENCES [dbo].[KhachHang] ([ID])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([IDNhanVien])
REFERENCES [dbo].[NhanVien] ([ID])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonChiTiet_HoaDon] FOREIGN KEY([IDHoaDon])
REFERENCES [dbo].[HoaDon] ([ID])
GO
ALTER TABLE [dbo].[HoaDonChiTiet] CHECK CONSTRAINT [FK_HoaDonChiTiet_HoaDon]
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonChiTiet_SanPham] FOREIGN KEY([IDSP])
REFERENCES [dbo].[SanPham] ([ID])
GO
ALTER TABLE [dbo].[HoaDonChiTiet] CHECK CONSTRAINT [FK_HoaDonChiTiet_SanPham]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_HangSanPham] FOREIGN KEY([IDHang])
REFERENCES [dbo].[HangSanPham] ([ID])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_HangSanPham]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_KhuyenMai] FOREIGN KEY([IDKM])
REFERENCES [dbo].[KhuyenMai] ([ID])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_KhuyenMai]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_PhuKien] FOREIGN KEY([IDPK])
REFERENCES [dbo].[PhuKien] ([ID])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_PhuKien]
GO
