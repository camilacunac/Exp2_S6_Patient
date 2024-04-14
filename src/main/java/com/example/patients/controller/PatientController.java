package com.example.patients.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.patients.Response;
import com.example.patients.dto.AttentionDTO;
import com.example.patients.dto.ConsultationDTO;
import com.example.patients.dto.UpdateDirectionDTO;
import com.example.patients.model.Attention;
import com.example.patients.model.Consultation;
import com.example.patients.model.Patient;
import com.example.patients.services.PatientService;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/pacientes")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/paciente/{id}")
    public ResponseEntity<Response> getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    @GetMapping("/consultas/{idPatient}")
    public List<Consultation> getConsultationsByPatientId(@PathVariable Long idPatient) {
        return patientService.getAllConsultationsByPatientId(idPatient);
    }

    @GetMapping("/atenciones/{idPatient}")
    public List<Attention> getAttentionsByPatientId(@PathVariable Long idPatient) {
        return patientService.getAllAttentionsByPatientId(idPatient);
    }

    @PostMapping("/agregar-paciente")
    public ResponseEntity<Response> addPatient(@RequestBody Patient patient) {
        return patientService.addPatient(patient);
    }

    @PostMapping("/agregar-consulta/{idPatient}")
    public ResponseEntity<Response> addConsultForPatient(@PathVariable Long idPatient,
            @RequestBody ConsultationDTO consulta) {
        return patientService.addConsultForPatient(idPatient, consulta);
    }

    @PostMapping("/agregar-atencion/{idPatient}")
    public ResponseEntity<Response> addAttetionForPatient(@PathVariable Long idPatient,
            @RequestBody AttentionDTO atencion) {
        return patientService.addAttentionForPatient(idPatient, atencion);
    }

    @PutMapping("/paciente/{idPatient}/actualizar-direccion")
    public ResponseEntity<Response> updatePatientDirection(@PathVariable Long idPatient,
            @RequestBody UpdateDirectionDTO direccion) {
        return patientService.updatePatientDirection(idPatient, direccion);
    }

    @DeleteMapping("/eliminar-paciente/{idPatient}")
    public ResponseEntity<Response> deletePatientById(@PathVariable Long idPatient) {
        return patientService.deletePatientById(idPatient);
    }
}
