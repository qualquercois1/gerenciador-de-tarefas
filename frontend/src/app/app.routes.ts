import { Routes } from '@angular/router';

import { MainLayoutComponent } from './layouts/main-layout/main-layout.component';
import { HomeComponent } from './pages/home/home.component';
import { TarefasComponent } from './pages/tarefas/tarefas.component';
import { TarefaDetalhesComponent } from './pages/tarefa-detalhes/tarefa-detalhes.component';

export const routes: Routes = [

    {
        path: '',
        component: MainLayoutComponent,
        children: [
            {
                path: 'home',
                component: HomeComponent
            },
            {
                path: 'tarefas',
                component: TarefasComponent
            },
            {
                path: 'tarefa/:id', 
                component: TarefaDetalhesComponent
            },
            {
                path: '',
                redirectTo: 'home',
                pathMatch: 'full'
            }
        ]
    }
];
