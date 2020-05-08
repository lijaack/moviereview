import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule }    from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { UserAccountComponent } from './account-user/user-account.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { CreateaccountComponent } from './createaccount/createaccount.component';
import { SearchMoviesComponent } from './search-movies/search-movies.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HomeComponent } from './home/home.component';
import { MovieCardComponent } from './movie-card/movie-card.component';
import { HttpClientModule , HttpClient}    from '@angular/common/http';
import { MovieComponent } from './movie/movie.component';
import { ReviewComponent } from './review/review.component';
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    UserAccountComponent,
    DashboardComponent,
    CreateaccountComponent,
    SearchMoviesComponent,
    NavbarComponent,
    HomeComponent,
    MovieCardComponent,
    MovieComponent,
    ReviewComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [HttpClient],
  bootstrap: [AppComponent]
})
export class AppModule { }
