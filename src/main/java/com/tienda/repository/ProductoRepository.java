
package com.tienda.repository;

import com.tienda.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductoRepository 
        extends JpaRepository<Producto, Long>{
    //Consulta ampliada jpa, se p
    
    public List<Producto> findByPrecioBetweenOrderByPrecio(
    double precioInf,
    double precioSup);
    
    //Consulta JPQL, se obtiene la lista de producto entre un rango de precios, ordenado precio
@Query(value = "SELECT a FROM Producto a WHERE a.precio BETWEEN :precioInf AND :precioSup ORDER BY a.precio")
public List<Producto> consultaJPQL(double precioInf, double precioSup);

//Consulta SQL, se obtiene la lista de producto entre un rango de precios, ordenado precio
@Query(nativeQuery = true,
       value = "SELECT * FROM producto a WHERE a.precio BETWEEN :precioInf AND :precioSup ORDER BY a.precio")
public List<Producto> consultaSQL(
    @Param("precioInf") double precioInf,
    @Param("precioSup") double precioSup);

    }


