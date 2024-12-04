package org.example.Repositorio;


import org.example.Modelo.EntidadeBase;

import java.util.List;

public interface RepositorioBase <T extends EntidadeBase>{

   void Adicionar (T entidade);
   void UpDate(T entidade);
   Optional<T> GetByBrinco(int n_brinco);
   void Delete ( int n_brinco);

}
