import { Component, OnInit, inject, signal } from '@angular/core';
import { TarefaService } from '../../services/tarefa.service';
import { Tarefa } from '../../models/tarefa';

import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-tarefas',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './tarefas.component.html',
  styleUrl: './tarefas.component.scss'
})
export class TarefasComponent {

  private tarefaService = inject(TarefaService);

  public tarefas = signal<Tarefa[]>([]);

  ngOnInit(): void {
    this.carregarTarefas();
  }

  carregarTarefas(): void {
    const usuarioId = 1;
    this.tarefaService.getTarefasPorUsuario(usuarioId).subscribe({
      next: (dados) => {
        this.tarefas.set(dados);
        console.log('Tarefas carregadas:', dados);
      },
      error: (erro) => {
        console.error('Erro ao carregar tarefas:', erro);
      }
    });
  }
}
