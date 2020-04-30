import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { CreateaccountComponent } from './createaccount/createaccount.component';
import { SearchMoviesComponent } from './search-movies/search-movies.component';
import { UserAccountComponent } from './account-user/user-account.component';
import {DashboardComponent} from './dashboard/dashboard.component';

const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'login', component: LoginComponent,  pathMatch: 'full' },
  { path: 'searchmovies', component: SearchMoviesComponent, pathMatch: 'full' },
  { path: 'createaccount', component: CreateaccountComponent, pathMatch: 'full' },
  { path: 'account-user', component: UserAccountComponent, pathMatch: 'full' }

 // { path: 'login', redirectTo: '/Login', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
