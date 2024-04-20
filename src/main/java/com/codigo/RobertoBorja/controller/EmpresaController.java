package com.codigo.RobertoBorja.controller;


import com.codigo.RobertoBorja.entity.EmpresaEntity;
import com.codigo.RobertoBorja.service.EmpresaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/examen/v1/empresa")
@AllArgsConstructor
@Tag(
        name = "API DE MANTENIMIENTO EMPRESAS - Roberto",
        description = "Esta api contiene todos los end points para realizar el mantenimiento de la entidad empresa"
)
public class EmpresaController {

    private final EmpresaService empresaService;
    @PostMapping("/crear")
    @Operation(summary = "Crear una nueva Empresa")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Empresa registrada exitosamente",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpresaEntity.class))}),
            @ApiResponse(responseCode = "201", description = "Empresa Creada exitosamente",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpresaEntity.class))}),
            @ApiResponse(responseCode = "400", description = "tu request esta mall",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpresaEntity.class))})

    })

    public ResponseEntity<EmpresaEntity> crear(@RequestBody EmpresaEntity empresaEntity){
        return ResponseEntity.ok(empresaService.crear(empresaEntity));
    }

    @GetMapping("/{id}")
    @Operation(summary = "buscar Una Empresa Por ID")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Empresa Encontrada",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpresaEntity.class))}),
            @ApiResponse(responseCode = "201", description = "Empresa Encontrada",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpresaEntity.class))}),
            @ApiResponse(responseCode = "400", description = "EL REQUEST ESTA MAL",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpresaEntity.class))})
    })
    public ResponseEntity<Optional<EmpresaEntity>> buscarporId(@PathVariable Long id){
        return ResponseEntity.ok(empresaService.buscarxId(id));
    }

    @GetMapping("/todos")
    @Operation(summary = "buscar TODAS LAS Empresa ")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Empresas Encontradas",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpresaEntity.class))}),
            @ApiResponse(responseCode = "201", description = "Empresas Encontradas",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpresaEntity.class))}),
            @ApiResponse(responseCode = "400", description = "EL REQUEST ESTA MAL",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpresaEntity.class))})
    })
    public ResponseEntity<List<EmpresaEntity>> buscarTodos(){
        return ResponseEntity.ok(empresaService.buscarAll());
    }


    @PutMapping("/actualizar/{id}")
    @Operation(summary = "actualizar Una Empresa Por ID")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Empresa Actualizada",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpresaEntity.class))}),
            @ApiResponse(responseCode = "201", description = "Empresa Actualizada",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpresaEntity.class))}),
            @ApiResponse(responseCode = "400", description = "EL REQUEST ESTA MAL",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpresaEntity.class))})
    })
    public ResponseEntity<EmpresaEntity> actualizar(@PathVariable Long id, @RequestBody EmpresaEntity empresaEntity){
        return ResponseEntity.ok(empresaService.actualizar(id,empresaEntity));
    }


    @DeleteMapping("/eliminar/{id}")
    @Operation(summary = "eliminar Una Empresa Por ID")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Empresa eliminada",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpresaEntity.class))}),
            @ApiResponse(responseCode = "201", description = "Empresa eliminada",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpresaEntity.class))}),
            @ApiResponse(responseCode = "400", description = "EL REQUEST ESTA MAL",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpresaEntity.class))})
    })
    public ResponseEntity<EmpresaEntity> eliminar(@PathVariable Long id){
        return ResponseEntity.ok(empresaService.borrar(id));
    }

}
