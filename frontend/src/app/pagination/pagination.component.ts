import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-pagination',
  templateUrl: './pagination.component.html',
  styleUrls: ['./pagination.component.css']
})
export class PaginationComponent {
  @Input() currentPage: number;
  @Input() totalPages: number;
  @Output() pageChanged = new EventEmitter<number>();

  goToPreviousPage() {
    if (this.hasPreviousPage()) {
      this.pageChanged.emit(this.currentPage - 1);
    }
  }

  goToNextPage() {
    if (this.hasNextPage()) {
      this.pageChanged.emit(this.currentPage + 1);
    }
  }

  hasPreviousPage() {
    return this.currentPage > 0;
  }

  hasNextPage() {
    return this.currentPage < this.totalPages-1;
  }
}
