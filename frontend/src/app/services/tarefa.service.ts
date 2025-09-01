import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Tarefa } from '../models/tarefa';

@Injectable({
  providedIn: 'root'
})
export class TarefaService {

  private http = inject(HttpClient);

  private apiUrl = 'http://localhost:8080/tarefa';

  constructor() { }

  getTarefasPorUsuario(usuarioId: number): Observable<Tarefa[]> {
    const url = `${this.apiUrl}/${usuarioId}`;
    return this.http.get<Tarefa[]>(url);
  }
}
