import { Component, OnInit } from '@angular/core';

import { Regiao } from 'src/app/shared/models/regiao';

import { RegiaoService } from 'src/app/shared/services/regiao.service';


@Component({
  selector: 'app-ocorrencias',
  templateUrl: './ocorrencias.component.html',
  styleUrls: ['./ocorrencias.component.css']
})
export class OcorrenciasComponent implements OnInit {

  regioes: Regiao[] = [];

  constructor(private regiaoService: RegiaoService) { }

  ngOnInit(): void {

    this.regiaoService.getRegioes().subscribe(
      (regioes: Regiao[]) => this.regioes = regioes,
      (err: any) => console.log('Ocorreu um erro ao carregar os dados dos clientes.')
    );
  }

}
