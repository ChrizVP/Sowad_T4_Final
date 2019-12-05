import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CotizacionnewService } from 'src/app/components/cotizacion/serviciow/cotizacionnew.service';
import { ServicioMecanicoDet } from '../../Modelo/ServicioMecanicoDet';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-reportcotizacion',
  templateUrl: './reportcotizacion.component.html',
  styleUrls: ['./reportcotizacion.component.css']
})
export class ReportcotizacionComponent implements OnInit {

  servicioMecanicoDets:ServicioMecanicoDet[];
  constructor(private router:Router, private service:CotizacionnewService) { }

  ngOnInit() {
    this.ReportCotizacion();
  }

  ReportCotizacion(){
    this.service.reportCotizacion()
    .subscribe(data=>{
      this.servicioMecanicoDets = data;
    })
  }

  

}
