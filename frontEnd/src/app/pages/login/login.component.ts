import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UsuarioModel } from 'src/app/models/usuario.model';
import { AuthService } from 'src/app/services/auth.service';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  usuario:UsuarioModel = new UsuarioModel();
  remember = false;

  constructor(private auth:AuthService, private router:Router) { }

  ngOnInit() {
    if (localStorage.getItem('email')) {
      this.usuario.email = localStorage.getItem('email')
      this.remember = true
    }
  }

  login(form:NgForm){

    if (form.invalid) {
      return;
    }

    Swal.fire({
      allowOutsideClick: false,
      type: 'info',
      text:'Espere porfavor...'
    });
    Swal.showLoading();

    this.auth.login(this.usuario)
      .subscribe(resp => {
        Swal.close();
        if (this.remember) {
          localStorage.setItem('email', this.usuario.email)
        }else if (localStorage.getItem('email')) {
          localStorage.removeItem('email')
        }
        this.router.navigateByUrl('/home');
    }, err => {
      console.log(err);
      Swal.fire({
        type: 'error',
        text:'Error al autenticar'
      });
    })
  }

}
