/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package business.service;

/**
 *
 * @author lyhai
 */
public interface IReportService {
    void isExpired();
    void isSelling();
    void isRunningOut();
    void showProductByCode(String code);
}
