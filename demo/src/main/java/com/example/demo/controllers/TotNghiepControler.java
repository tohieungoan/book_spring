package com.example.demo.controllers;

import com.example.demo.models.TotNghiep;
import com.example.demo.models.SinhVien;
import com.example.demo.service.TotNghiepService;
import com.example.demo.service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/tot-nghiep")
public class TotNghiepControler {

    @Autowired
    private TotNghiepService totNghiepService;

    @Autowired
    private SinhVienService sinhVienService;

    // Hiển thị danh sách tốt nghiệp
    @GetMapping
    public String getAllTotNghiep(Model model) {
        List<TotNghiep> totNghiepList = totNghiepService.getAllTotNghiep();
        model.addAttribute("totNghiepList", totNghiepList);
        return "tot-nghiep/list"; // Trả về view danh sách tốt nghiệp
    }

    // Hiển thị trang tạo tốt nghiệp
    @GetMapping("/create")
    public String createTotNghiepForm(Model model) {
        TotNghiep totNghiep = new TotNghiep();
        model.addAttribute("totNghiep", totNghiep);
        return "createTotNghiep"; // Trả về view tạo tốt nghiệp
    }

    // Lưu thông tin tốt nghiệp
    @PostMapping("/save")
    public String save(@ModelAttribute TotNghiep totNghiep, Model model) {
        // Lấy CMND từ đối tượng TotNghiep
        String cmnd = totNghiep.getSoCMND();

        // Kiểm tra xem sinh viên có tồn tại với CMND này không
        Optional<SinhVien> sinhVien = sinhVienService.getSinhVienBySoCMND(cmnd);

        if (sinhVien.isEmpty()) {
            // Nếu không có sinh viên, chuyển hướng đến trang tạo sinh viên
            model.addAttribute("error", "Sinh viên với CMND này không tồn tại. Vui lòng tạo sinh viên trước.");
            return "redirect:/sinh-vien/create"; // Chuyển hướng đến trang tạo sinh viên
        }

        // Nếu sinh viên tồn tại, tiến hành lưu thông tin tốt nghiệp
        try {
            totNghiepService.save(totNghiep);
        } catch (Exception e) {
            // In chi tiết lỗi ra console
            System.out.println("Có lỗi xảy ra khi lưu thông tin tốt nghiệp: " + e.getMessage());
            e.printStackTrace();  // In chi tiết stack trace ra console
            model.addAttribute("error", "Có lỗi xảy ra khi lưu thông tin tốt nghiệp!");
        }
        return "redirect:/sinh-vien/all";  // Quay lại trang danh sách sinh viên sau khi lưu thành công
    }

    // Xử lý chỉnh sửa thông tin tốt nghiệp
    @PostMapping("/update")
    public String updateTotNghiep(@ModelAttribute TotNghiep totNghiep, RedirectAttributes redirectAttributes) {
        totNghiepService.save(totNghiep);
        redirectAttributes.addFlashAttribute("message", "Thông tin tốt nghiệp đã được cập nhật thành công!");
        return "redirect:/tot-nghiep"; // Sau khi cập nhật, chuyển đến trang danh sách tốt nghiệp
    }
}
