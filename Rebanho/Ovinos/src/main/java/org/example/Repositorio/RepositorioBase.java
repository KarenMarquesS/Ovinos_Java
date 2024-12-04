package org.example.Repositorio;


import org.example.Modelo.EntidadeBase;

import java.util.List;

public interface RepositorioBase <T extends EntidadeBase>{

   void Adicionar (T entidade);
   void UpDate(T entidade);
   void Delete ( int id);

}
