export interface Tarefa {
    id: number;
    titulo: string;
    descricao: string;
    data_criacao: string; 
    data_conclusao: string | null; 
    status: string;
}
