import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from "./components/login/login.component";
import {HttpClientModule} from "@angular/common/http";
import {GuardGuard} from "./services/guard.guard";
import {SigninComponent} from "./components/signin/signin.component";
import {GameComponent} from "./components/game/game.component";
import {LobbyComponent} from "./components/lobby/lobby.component";

const routes: Routes = [
  {path:'game',component:GameComponent, canActivate:[GuardGuard]},
  {path:'lobby',component:LobbyComponent, canActivate:[GuardGuard]},
  {path:'login',component:LoginComponent},
  {path:'signin',component:SigninComponent},
  {path:'',redirectTo:'login',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes), HttpClientModule],
  exports: [RouterModule]
})
export class AppRoutingModule { }
