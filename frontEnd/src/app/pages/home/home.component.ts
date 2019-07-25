import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { Router } from '@angular/router';
import { UsuarioModel } from 'src/app/models/usuario.model';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  usuario:UsuarioModel = new UsuarioModel();

  constructor(private auth:AuthService, private router:Router) { }
  
  ngOnInit() {
    this.auth.getUser(localStorage.getItem('token')).
    subscribe(resp =>{
      console.log(resp);
      this.usuario.email = resp.userName;
      this.usuario.nombre = resp.name;
    }, err => {
      console.log(err);
      Swal.fire({
        type: 'error',
        text:'Error al autenticar'
      });
    })
    //this.usuario.nombre = tempUser['user'].name;
    //this.usuario.email = tempUser['user'].userName;
    console.log(this.usuario);
  }

  salir(){
    this.auth.logout();
    this.router.navigateByUrl('/login');
  }

}
