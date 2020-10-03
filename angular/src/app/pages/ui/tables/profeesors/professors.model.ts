// Table data
export interface Table {
    id: number;
    name: string;
    courseCode: string;
    courseCradit: number;
    coursePrice: number;
    professorName: string;
}

// Search Data
export interface SearchResult {
    tables: Table[];
    total: number;
}
