import { Component, OnInit } from '@angular/core';
import { City } from '../model/city';
import { CityService } from '../service/city.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-city-list',
  templateUrl: './city-list.component.html',
  styleUrls: ['./city-list.component.css']
})
export class CityListComponent implements OnInit {

  cities: City[];
  page: number = 0;
  size: number = 10;
  name: string = '';
  totalPages: number = 1;
  constructor(private cityService: CityService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      this.page = params['page'] ? params['page'] : this.page;
      this.size = params['size'] ? params['size'] : this.size;
      this.name = params['name'] ? params['name'] : this.name;
    });
    this.getCities();
  }
  getCities() {
    this.cityService.findAll(this.page, this.size, this.name).subscribe(data => {
      this.cities = data.content;
      this.totalPages = data.totalPages;
      if (this.totalPages < this.page){
        this.page = this.totalPages-1;
        this.getCities();
      }
    });
  }

  onPageChange(page: number) {
    this.page = page;
    this.getCities();
  }

  onPageSizeChange(size: number) {
    this.size = size;
    this.getCities();
  }

  onNameFilterChange(name: string) {
    this.name = name;
    this.getCities();
  }

}
