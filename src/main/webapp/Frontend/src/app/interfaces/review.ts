import {User} from './user';
export interface Review{
    id?:number,
    review:string,
    movieScore:number,
    dateCreated:string,
    movieID:string,
    userID:string,
    user?:{
        id?:number,
        name:string,
        username:string,
        country:string,
        gender:string,
        birthday:string,
        isCritic?:boolean
    }
}