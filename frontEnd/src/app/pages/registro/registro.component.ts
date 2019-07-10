import { Component, OnInit } from '@angular/core';
import { UsuarioModel } from '../../models/usuario.model';
import { NgForm } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit {

  usuario:UsuarioModel;
  remember = false;

  constructor( private auth:AuthService, private router:Router) { }

  ngOnInit() {
    this.usuario = new UsuarioModel();
   }

   onSubmit(form:NgForm ){
      if (form.invalid) {
            return;
       }

       Swal.fire({
        allowOutsideClick: false,
        type: 'info',
        text:'Espere porfavor...'
      });
      Swal.showLoading();
       
       this.auth.createUser(this.usuario).subscribe( resp => {
         console.log(resp);
         Swal.close();
         if (this.remember) {
          localStorage.setItem('email', this.usuario.email)
          }
         this.router.navigateByUrl('/home')
       }, err => {
        Swal.fire({
          type: 'error',
          text:'Error al registrarse'
        });
         console.error(err);
       });
    }

}
