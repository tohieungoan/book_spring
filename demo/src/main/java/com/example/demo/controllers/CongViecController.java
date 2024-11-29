package com.example.demo.controllers;

import com.example.demo.models.CongViec;
import com.example.demo.models.SinhVien;
import com.example.demo.service.CongViecService;
import com.example.demo.service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cong-viec")
public class CongViecController {

    @Autowired
    private CongViecService congViecService;

    @Autowired
    private SinhVienService sinhVienService;

    // Hiển thị danh sách công việc
    @GetMapping
    public String getAllCongViec(Model model) {
        List<CongViec> congViecList = congViecService.getAllCongViec();
        model.addAttribute("congViecList", congViecList);
        return "cong-viec/list"; // Trả về view danh sách công việc
    }

    // Hiển thị trang tạo công việc
    @GetMapping("/create")
    public String createCongViecForm(Model model) {
        CongViec congViec = new CongViec();
        model.addAttribute("congViec", congViec);
        return "createCongViec"; // Trả về view tạo công việc
    }
    @PostMapping("/save")
    public String save(@ModelAttribute CongViec congViec, Model model) {
        // Kiểm tra nếu sinh viên có cmnd trong cơ sở dữ liệu
        String cmnd = congViec.getSoCMND(); // Giả sử bạn lấy cmnd từ congViec

        // Kiểm tra xem sinh viên với cmnd này có tồn tại không
        Optional<SinhVien> sinhVien = sinhVienService.getSinhVienBySoCMND(cmnd);

        if (sinhVien.isEmpty()) {
            // Nếu sinh viên không tồn tại, chuyển hướng đến trang tạo sinh viên
            model.addAttribute("error", "Sinh viên với CMND này không tồn tại. Vui lòng tạo sinh viên trước.");
            return "redirect:/sinh-vien/create";  // Trang tạo sinh viên
        }

        // Nếu sinh viên tồn tại, tiến hành lưu công việc
        try {
            congViecService.saveCongViec(congViec);
        } catch (Exception e) {
            // In chi tiết lỗi ra console
            System.out.println("Có lỗi xảy ra khi lưu công việc: " + e.getMessage());
            e.printStackTrace();  // In chi tiết stack trace ra console
            model.addAttribute("error", "Có lỗi xảy ra khi lưu thông tin công việc!");
            return "redirect:/cong-viec/create";  // Quay lại trang tạo công việc
        }

        return "redirect:/sinh-vien/all";  // Quay lại trang danh sách sinh viên sau khi lưu thành công
    }

//    @GetMapping("/create")
//    public String createSinhVien(Model model) {
//        SinhVien sinhVien = new SinhVien();
//        sinhVien.setTotNghiepList(new ArrayList<>());  // Initialize the totNghiepList to avoid null pointer
//        model.addAttribute("sinhVien", sinhVien);
//        return "createSinhVien";
//    }

//    // Xử lý tạo công việc mới
//    @PostMapping("/save")
//    public String saveCongViec(@ModelAttribute SinhVien sinhVien, RedirectAttributes redirectAttributes) {
//        congViecService.saveCongViec(congViec);
//        redirectAttributes.addFlashAttribute("message", "Công việc đã được lưu thành công!");
//        return "redirect:/cong-viec"; // Sau khi lưu, chuyển đến trang danh sách công việc
//    }

//    // Hiển thị chi tiết công việc
//    @GetMapping("/detail/{soCMND}/{ngayVaoCongTy}")
//    public String getCongViecDetail(@PathVariable String soCMND, @PathVariable String ngayVaoCongTy, Model model) {
//        Optional<CongViec> congViec = congViecService.getCongViecById(soCMND, ngayVaoCongTy);
//        if (congViec.isPresent()) {
//            model.addAttribute("congViec", congViec.get());
//            return "cong-viec/detail"; // Trả về view chi tiết công việc
//        } else {
//            model.addAttribute("message", "Công việc không tồn tại");
//            return "redirect:/cong-viec"; // Nếu không tìm thấy công việc, quay lại trang danh sách
//        }
//    }
//
//    // Xử lý chỉnh sửa công việc
//    @GetMapping("/edit/{soCMND}/{ngayVaoCongTy}")
//    public String editCongViecForm(@PathVariable String soCMND, @PathVariable String ngayVaoCongTy, Model model) {
//        Optional<CongViec> congViec = congViecService.getCongViecById(soCMND, ngayVaoCongTy);
//        if (congViec.isPresent()) {
//            List<SinhVien> sinhVienList = sinhVienService.getAllSinhVien();
//            model.addAttribute("sinhVienList", sinhVienList);
//            model.addAttribute("congViec", congViec.get());
//            return "cong-viec/edit"; // Trả về view chỉnh sửa công việc
//        } else {
//            model.addAttribute("message", "Công việc không tồn tại");
//            return "redirect:/cong-viec"; // Nếu không tìm thấy công việc, quay lại trang danh sách
//        }
//    }

    // Xử lý cập nhật công việc
    @PostMapping("/update")
    public String updateCongViec(@ModelAttribute CongViec congViec, RedirectAttributes redirectAttributes) {
        congViecService.saveCongViec(congViec);
        redirectAttributes.addFlashAttribute("message", "Công việc đã được cập nhật thành công!");
        return "redirect:/cong-viec"; // Sau khi cập nhật, chuyển đến trang danh sách công việc
    }

//    // Xử lý xóa công việc
//    @GetMapping("/delete/{soCMND}/{ngayVaoCongTy}")
//    public String deleteCongViec(@PathVariable String soCMND, @PathVariable String ngayVaoCongTy, RedirectAttributes redirectAttributes) {
//        congViecService.deleteCongViec(soCMND, ngayVaoCongTy);
//        redirectAttributes.addFlashAttribute("message", "Công việc đã được xóa thành công!");
//        return "redirect:/cong-viec"; // Sau khi xóa, quay lại trang danh sách công việc
//    }
}
