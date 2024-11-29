package com.example.demo.controller;

import com.example.demo.Service.SinhVienService;
import com.example.demo.model.SinhVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sinh-vien")  // Base path for the controller
public class SinhVienController {

    @Autowired
    private SinhVienService sinhVienService;

    // Hiển thị tất cả sinh viên
    @GetMapping("/all")
    public String getAllSinhVien(Model model) {
        List<SinhVien> listSinhVien = sinhVienService.getAllSinhVien();
        model.addAttribute("listSinhVien", listSinhVien);
        return "listSinhVien";  // Return the view for listing all students
    }

    // View details for a single student by CMND
    @GetMapping("/so-cmnd/{soCMND}")
    public String getSinhVienDetails(@PathVariable String soCMND, Model model) {
        // Fetching student details using the service
        SinhVien sinhVien = sinhVienService.getSinhVienWithDetails(soCMND);

        if (sinhVien == null) {
            model.addAttribute("error", "Sinh viên không tìm thấy");
            return "error"; // Return error page if student not found
        }

        // Add student details to the model for the view
        model.addAttribute("sinhVien", sinhVien);
        return "sinhVienDetail"; // Return student detail view
    }

    // Form to create a new student
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("sinhVien", new SinhVien());
        return "createSinhVien";  // Return the create student form view
    }

    // Save new student
    @PostMapping("/save")
    public String saveSinhVien(@ModelAttribute SinhVien sinhVien) {
        sinhVienService.saveSinhVien(sinhVien);
        return "redirect:/sinh-vien/all";  // Redirect to the list of all students
    }
}
