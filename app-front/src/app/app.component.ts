import { Component, Input } from '@angular/core';
import { AppService } from './app.service';

@Component({
  selector: 'app-root',
  //templateUrl: './app.component.html',
  //styleUrls: ['./app.component.css'],
  template: `
      <h1>{{title}}</h1>
      <h2>{{hello}}</h2>
      <h4>Editing: {{this.edit_id}} </h4>
      <div>
        <label>Name: </label>
        <input type="text" id="name" [value]="name" (change)="onChangeName($event)">
        <br><br>
        <label>Area(m2): </label>
        <input type="number" min="0" id="area" [value]="area" (change)="onChangeArea($event)">
        <br><br>
        <label>Parent ID: </label>
        <input id="parentLoc" [value]="parent" (change)="onChangeParent($event)">
        <br><br>
        <button (click)="addLocation()">Submit</button>
        <button (click)="clean()">Clean</button>
      </div>

      <div>
      <table style="width:40%">
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Area(m2)</th>
          <th>Parent ID</th>
          <th>Actions</th>
        </tr>
        <tr *ngFor="let l of list_test">
          <td>{{ l.id }}</td>
          <td>{{ l.name }}</td>
          <td>{{ l.area_m2 }}</td>
          <td>{{ l.parentLoc }}</td>
          <td>
            <button (click)="edit(l.id, l.name, l.area_m2, l.parentLoc)">Edit</button>
            <button (click)="delete(l.id)">Delete</button>
          </td>
        </tr>
      </table>
      </div>

    `
})
export class AppComponent {
  title = 'Locations';
  hello = 'Welcome to front-app';
  list_test = [];

  edit_id = null;
  name = null;
  area = 0;
  parent = null;


  constructor(private AppService: AppService) {
    this.getAllLocations();
  }

  getAllLocations(){
    this.AppService.getAllLocations().subscribe((data) => {
      this.list_test = JSON.parse(JSON.stringify(data));
    });;
  }

  addLocation(){
    if(this.edit_id){
      this.AppService.editLocation(this.edit_id, this.name, this.area, this.parent).subscribe((data) => {
        this.getAllLocations();
        this.clean();
      });
    }else{
      this.AppService.addLocation(this.name, this.area, this.parent).subscribe((data) => {
        this.getAllLocations();
        this.clean();
      });
    }
  }

  clean(){
    this.edit_id = null;
    this.name = null;
    this.area = 0;
    this.parent = null;
  }

  onChangeName(event: any) {
    this.name = event.target.value;
  }

  onChangeArea(event: any) {
    this.area = event.target.value;
  }

  onChangeParent(event: any) {
    this.parent = event.target.value;
  }

  delete(id){
    this.AppService.deleteLocation(id).subscribe((data) => {
      this.getAllLocations();
      this.clean();
    });
  }

  edit(id, name, area, parent){
    this.edit_id = id;
    this.name = name;
    this.area = area;
    this.parent = parent;
  }

}